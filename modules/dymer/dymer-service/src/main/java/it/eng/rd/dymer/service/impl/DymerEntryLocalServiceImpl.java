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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.base.DymerEntryLocalServiceBaseImpl;

@Component(
	property = "model.class.name=it.eng.rd.dymer.model.DymerEntry",
	service = AopService.class
)
public class DymerEntryLocalServiceImpl extends DymerEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(serviceContext.getUserId());

		Date now = new Date();

		long entryId = counterLocalService.increment();

		DymerEntry entry = dymerEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(serviceContext.getUserId());
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setDymerId(dymerId);
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, addDymerEntry method-----------------------------");
			
			_log.debug("uuid: " +serviceContext.getUuid());
			_log.debug("userId: " +serviceContext.getUserId());
			_log.debug("groupId: " +groupId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}
		
		entry = dymerEntryPersistence.update(entry);
		
		Dymer dymer = dymerPersistence.fetchByPrimaryKey(dymerId);
		String dymerDomainName = "";
		if (serviceContext.getAttribute("dymerDomainName")!=null) {
			dymerDomainName = (String) serviceContext.getAttribute("dymerDomainName");
		}
		dymer.setName(dymerDomainName);
		dymerPersistence.update(dymer);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getTitle(), entry.getExtContent(), entry.getTitle(), null,
                null, 0, 0, null);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetLink");
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
			    DymerEntry.class.getName(), entryId, false, true, true);

		if (_log.isDebugEnabled()) 
			_log.debug("generated permission");
		
		return entry;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId,
			long entryId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		

		Date now = new Date();

		DymerEntry entry =
			dymerEntryPersistence.findByPrimaryKey(entryId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		entry.setUserId(serviceContext.getUserId());
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);
		//entry.setExpandoBridgeAttributes(serviceContext);
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, updateDymerEntry method-----------------------------");
			_log.debug("dymerId: " +dymerId);
			_log.debug("dymerEntryId: " +entryId);
			_log.debug("userId: " +serviceContext.getUserId());
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}

		entry = dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
	              serviceContext.getScopeGroupId(),
	              entry.getCreateDate(), entry.getModifiedDate(),
	              DymerEntry.class.getName(), entryId, entry.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              entry.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, entry.getTitle(), entry.getExtContent(),
	              entry.getTitle(), null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetEntry");
	
		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetLink");
		
		return entry;
	}
	
	/********************************************************************************************************
	 * Old local services
	 */
	
	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId,
			long userId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("DymerEntryLocalServiceImpl, addDymerEntry method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		long entryId = counterLocalService.increment();

		DymerEntry entry = dymerEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setDymerId(dymerId);
		
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);
		
		if (_log.isDebugEnabled()) {
			_log.debug("uuid: " +serviceContext.getUuid());
			_log.debug("userId: " +userId);
			_log.debug("groupId: " +groupId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}
		
		
		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getExtContent(), null, null, null,
                null, 0, 0, null);
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    DymerEntry.class.getName(), entryId, false, true, true);

		if (_log.isDebugEnabled())
			_log.debug("generated permission");
		return entry;
	}
	
	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId,
			long userId,
			long entryId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("DymerEntryLocalServiceImpl, updateDymerEntry method");

		Date now = new Date();

		DymerEntry entry =
			dymerEntryPersistence.findByPrimaryKey(entryId);
		
		User user = userLocalService.getUserById(userId);

		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);
		
		if (_log.isDebugEnabled()) {
			_log.debug("dymerId: " +dymerId);
			_log.debug("dymerEntryId: " +entryId);
			_log.debug("userId: " +userId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}

		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
	              serviceContext.getScopeGroupId(),
	              entry.getCreateDate(), entry.getModifiedDate(),
	              DymerEntry.class.getName(), entryId, entry.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              entry.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, entry.getExtContent(), null,
	              null, null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");
	
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");
		
		return entry;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(DymerEntry entry) throws PortalException, SystemException {
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, deleteDymerEntry method");
			_log.debug("entryId "+entry.getEntryId());
		}
			
		dymerEntryPersistence.remove(entry);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                DymerEntry.class.getName(), entry.getEntryId());
		
		if (_log.isDebugEnabled())
			_log.debug("removed assetEntry");
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		
		if (_log.isDebugEnabled())
			_log.debug("removed assetLink");
		
		try {
			assetEntryLocalService.deleteEntry(assetEntry);
		} catch (PortalException e) {
			long assetEntryId = 0;
			if (assetEntry!=null) {
				assetEntryId = assetEntry.getEntryId();
			}
			_log.error("An error occurred while deleting asseEntry "+assetEntryId);
			_log.error(e,e);
		}

		return entry;
	}
	
	@Indexable(type = IndexableType.DELETE)
    public DymerEntry deleteDymerEntry(long entryId, long userId) throws PortalException, SystemException {
		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

        return deleteDymerEntry(entry);
    }

	public DymerEntry deleteDymerEntry(long entryId) throws PortalException, SystemException {

		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		return deleteDymerEntry(entry);
	}
	
	public List<DymerEntry> getDymerEntries(long groupId, long dymerId) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end) throws PortalException, SystemException {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end, OrderByComparator<DymerEntry> obc) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end, obc);
	}

	public DymerEntry getDymerEntry(long entryId) throws PortalException, SystemException {
		return dymerEntryPersistence.findByPrimaryKey(entryId);
	}

	public int getDymerEntriesCount(long groupId, long dymerId) {
		return dymerEntryPersistence.countByG_D(groupId, dymerId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(DymerEntryLocalServiceImpl.class);
}