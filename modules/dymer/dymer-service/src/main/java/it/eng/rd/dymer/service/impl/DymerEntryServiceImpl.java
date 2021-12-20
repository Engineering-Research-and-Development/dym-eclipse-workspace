/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.rd.dymer.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerEntryLocalServiceUtil;
import it.eng.rd.dymer.service.DymerLocalServiceUtil;
import it.eng.rd.dymer.service.base.DymerEntryServiceBaseImpl;
import it.eng.rd.dymer.service.persistence.DymerEntryUtil;


@Component(
	property = {
		"json.web.service.context.name=dym",
		"json.web.service.context.path=DymerEntry"
	},
	service = AopService.class
)
public class DymerEntryServiceImpl extends DymerEntryServiceBaseImpl {

	@JSONWebService(value="update",method="POST")
	public DymerEntry update(
			String dymerDomainName,
			String emailAddress,
			long companyId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent
	) {
		
		ServiceContext sc = new ServiceContext();
		sc.setAttribute("dymerDomainName", dymerDomainName);
		User user;
		try {
			
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			sc.setUserId(user.getUserId());
			sc.setScopeGroupId(groupId);
			sc.setUuid(UUID.randomUUID().toString());
			Date now = new Date();
			sc.setCreateDate(now);
			sc.setModifiedDate(now);
			sc.setAssetCategoryIds(new long[] {});
			sc.setAssetTagNames(new String[] {});
			sc.setAssetLinkEntryIds(new long[] {});
		} catch (PortalException e1) {
			_log.error("An error occurred while invoking remote update service");
			_log.error(e1,e1);
		}
		
		try {
			
			DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
			long dymerId = 0;
			
			if(DymerLocalServiceUtil.getDymersCount(groupId) > 0) {	
				dymerId = DymerLocalServiceUtil.getDymers(groupId).get(0).getDymerId();
			}
			
			// check title and content
			
			if (Validator.isNotNull(title)) {
				int titleMaxLength = ModelHintsUtil.getMaxLength(
					DymerEntry.class.getName(), "title");

				if (title.length() > titleMaxLength) {
					title = HtmlUtil.extractText(
							StringUtil.shorten(title, titleMaxLength));
				}
				
				_log.info("titleMaxLength: "+titleMaxLength);
				_log.info("title extracted: "+title);
				if (Validator.isNotNull(title)) {
					_log.info("title extracted length: "+title.length());
				}
			}

			if (Validator.isNotNull(extContent)) {
//				int contentMaxLength = ModelHintsUtil.getMaxLength(
//						DymerEntry.class.getName(), "extContent");

				if (extContent.length() > 32766) {
					extContent = HtmlUtil.extractText(
							StringUtil.shorten(extContent, 32700));
				}
				_log.info("contentMaxLength: "+32700);
				_log.info("extContent extracted: "+extContent);
				if (Validator.isNotNull(extContent)) {
					_log.info("extContent extracted length: "+extContent.length());
				}
				
			}
			
			
			if(dymerEntry != null) {
				
				long entryId = dymerEntry.getEntryId();
				
				dymerEntry = DymerEntryLocalServiceUtil.updateDymerEntry(
						dymerId,
						entryId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			} else {
				dymerEntry = DymerEntryLocalServiceUtil.addDymerEntry(
						dymerId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			}
			return dymerEntry;
		} catch (PortalException e) {
			_log.error("An error occurred while invoking remote update service");
			_log.error(e,e);
			return null;
		}
	}
	
	@JSONWebService(value="delete",method="POST")
    public void delete(
    		String emailAddress,
    		long companyId,
            String index,
            String type,
            String id
    ) {
        
        ServiceContext sc = new ServiceContext();
    
        User user;
        try {
        	user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			sc.setUserId(user.getUserId());
            
            // uuid
            sc.setUuid(UUID.randomUUID().toString());
            Date now = new Date();
            sc.setCreateDate(now);
            sc.setModifiedDate(now);
            
            sc.setAssetCategoryIds(new long[] {});
            sc.setAssetTagNames(new String[] {});
            
            sc.setAssetLinkEntryIds(new long[] {});
        } catch (PortalException e1) {
            e1.printStackTrace();
        }
        
        DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);

        if(dymerEntry != null) {
            try {
                DymerEntryLocalServiceUtil.deleteDymerEntry(dymerEntry.getEntryId(), sc.getUserId());
            } catch (PortalException e) {
            	_log.error("An error occured while deleting Dymer resource [id: "+id+", index: "+index+", type: "+type+", email: "+emailAddress+", companyId: "+companyId+"]");
                _log.error(e, e);
            }
                    
        } else {
            _log.warn("No Dymer resource found");
        }
    }
	
	/********************************************************************************************************
	 * Old remote services
	 */
	
	@Deprecated
	@JSONWebService(value="update",method="POST")
	public DymerEntry update(
			long userId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent
	) {
		
		ServiceContext sc = new ServiceContext();
		
		User user;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			sc.setScopeGroupId(groupId);
			
			sc.setUuid(UUID.randomUUID().toString());
			Date now = new Date();
			sc.setCreateDate(now);
			sc.setModifiedDate(now);
			
			sc.setAssetCategoryIds(new long[] {});
			sc.setAssetTagNames(new String[] {});
			
			sc.setAssetLinkEntryIds(new long[] {});
		} catch (PortalException e1) {
			_log.error("An error occurred while invoking user service");
			_log.error(e1,e1);
		}
		
		try {
			
			DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
			long dymerId = 0;
			
			if(DymerLocalServiceUtil.getDymersCount(groupId) > 0) {	
				dymerId = DymerLocalServiceUtil.getDymers(groupId).get(0).getDymerId();
			}
			
			// check title and content
			
			if (Validator.isNotNull(title)) {
				int titleMaxLength = ModelHintsUtil.getMaxLength(
					DymerEntry.class.getName(), "title");

				if (title.length() > titleMaxLength) {
					title = HtmlUtil.extractText(
							StringUtil.shorten(title, titleMaxLength));
				}
			}

			if (Validator.isNotNull(extContent)) {
				int contentMaxLength = ModelHintsUtil.getMaxLength(
						DymerEntry.class.getName(), "extContent");

				if (extContent.length() > contentMaxLength) {
					extContent = HtmlUtil.extractText(
							StringUtil.shorten(extContent, contentMaxLength));
				}
			}
			
			if(dymerEntry != null) {
				
				long entryId = dymerEntry.getEntryId();
				
				DymerEntryLocalServiceUtil.updateDymerEntry(
						dymerId,
						userId,
						entryId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			} else {
				DymerEntryLocalServiceUtil.addDymerEntry(
						dymerId,
						userId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			}

		} catch (PortalException e) {
			_log.error("An error occurred while invoking remote update service");
			_log.error(e,e);
		}
		return null;
		
	}
	
	@Deprecated
	@JSONWebService(value="delete",method="POST")
    public void delete(
            long userId,
            String index,
            String type,
            String id
    ) {
        
        ServiceContext sc = new ServiceContext();
    
        User user;
        try {
            user = UserLocalServiceUtil.getUser(userId);
            
            sc.setUuid(UUID.randomUUID().toString());
            Date now = new Date();
            sc.setCreateDate(now);
            sc.setModifiedDate(now);
            sc.setAssetCategoryIds(new long[] {});
            sc.setAssetTagNames(new String[] {});
            sc.setAssetLinkEntryIds(new long[] {});
        } catch (PortalException e1) {
        	_log.error("An error occurred while invoking user service");
			_log.error(e1,e1);
        }
        
        DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);

        if(dymerEntry != null) {
            try {
                DymerEntryLocalServiceUtil.deleteDymerEntry(dymerEntry.getEntryId(), userId);
            } catch (PortalException e) {
            	_log.error("An error occurred while invoking delete update service");
    			_log.error(e,e);
            }
                    
        } else {
           _log.warn("No dymerEntry to delete");
        }
    }
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerEntryServiceImpl.class);
}