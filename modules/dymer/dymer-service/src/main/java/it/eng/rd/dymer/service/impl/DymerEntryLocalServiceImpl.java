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
		throws PortalException {
		
		_log.info("DymerEntryLocalServiceImpl, addDymerEntry method");

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
		// entry.setExpandoBridgeAttributes(serviceContext);
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
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		_log.info("dymerId: " +dymerId);
		
		_log.info("index: " +index);
		_log.info("type: " +type);
		_log.info("id: " +id);
		_log.info("url: " +url);
		_log.info("title: " +title);
		_log.info("extContent: " +extContent);
		
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
                ContentTypes.TEXT_HTML, entry.getExtContent(), null, null, null,
                null, 0, 0, null);
		
		_log.info("generated assetEntry");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		//set permission
		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
			    DymerEntry.class.getName(), entryId, false, true, true);

		_log.info("generated permission");
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
		
		_log.info("DymerEntryLocalServiceImpl, updateDymerEntry method");

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
		_log.info("dymerId: " +dymerId);
		_log.info("dymerEntryId: " +entryId);
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		_log.info("dymerId: " +dymerId);
		
		_log.info("index: " +index);
		_log.info("type: " +type);
		_log.info("id: " +id);
		_log.info("url: " +url);
		_log.info("title: " +title);
		_log.info("extContent: " +extContent);

		entry = dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
	              serviceContext.getScopeGroupId(),
	              entry.getCreateDate(), entry.getModifiedDate(),
	              DymerEntry.class.getName(), entryId, entry.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              entry.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, entry.getExtContent(), null,
	              null, null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		_log.info("generated assetEntry");
	
		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
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
		throws PortalException {
		
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
		// entry.setExpandoBridgeAttributes(serviceContext);
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
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +userId);
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		_log.info("dymerId: " +dymerId);
		
		_log.info("index: " +index);
		_log.info("type: " +type);
		_log.info("id: " +id);
		_log.info("url: " +url);
		_log.info("title: " +title);
		_log.info("extContent: " +extContent);
		
		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getExtContent(), null, null, null,
                null, 0, 0, null);
		
		_log.info("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		//set permission
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    DymerEntry.class.getName(), entryId, false, true, true);

		_log.info("generated permission");
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
		//entry.setExpandoBridgeAttributes(serviceContext);
		_log.info("dymerId: " +dymerId);
		_log.info("dymerEntryId: " +entryId);
		_log.info("userId: " +userId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		_log.info("dymerId: " +dymerId);
		
		_log.info("index: " +index);
		_log.info("type: " +type);
		_log.info("id: " +id);
		_log.info("url: " +url);
		_log.info("title: " +title);
		_log.info("extContent: " +extContent);

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
		
		_log.info("generated assetEntry");
	
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
//		serviceContext non valorizzato
//		https://docs.liferay.com/portal/7.0/javadocs/portal-kernel/com/liferay/portal/kernel/service/permission/ModelPermissions.html
//		resourceLocalService.updateResources(
//			      user.getCompanyId(), serviceContext.getScopeGroupId(), 
//			      DymerEntry.class.getName(), entryId, 
//			      serviceContext.getModelPermissions());
		
		
		return entry;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(DymerEntry entry) {
		
		_log.info("DymerEntryLocalServiceImpl, deleteDymerEntry method");
		
		dymerEntryPersistence.remove(entry);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                DymerEntry.class.getName(), entry.getEntryId());
		
		_log.info("removed assetEntry");
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		
		_log.info("removed assetLink");
		
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
    public DymerEntry deleteDymerEntry(long entryId, long userId) throws PortalException {
		_log.info("deleteDymerEntry method");
		_log.info("entryId "+entryId);
		_log.info("userId "+userId);
		
		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

        return deleteDymerEntry(entry);
    }

	public DymerEntry deleteDymerEntry(long entryId) throws PortalException {

		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		return deleteDymerEntry(entry);
	}
	
	public List<DymerEntry> getDymerEntries(long groupId, long dymerId) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end) throws SystemException {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end, OrderByComparator<DymerEntry> obc) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end, obc);
	}

	public DymerEntry getDymerEntry(long entryId) throws PortalException {
		return dymerEntryPersistence.findByPrimaryKey(entryId);
	}

	public int getDymerEntriesCount(long groupId, long dymerId) {
		return dymerEntryPersistence.countByG_D(groupId, dymerId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(DymerEntryLocalServiceImpl.class);
}