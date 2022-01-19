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

package it.eng.rd.collaborativecreation.service.impl;

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

import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.service.base.CocreationLocalServiceBaseImpl;

/**
 * The implementation of the cocreation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.CocreationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see CocreationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Cocreation",
	service = AopService.class
)
public class CocreationLocalServiceImpl extends CocreationLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Cocreation addCocreation(
			long challengeId,
			String title,
			String description,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("CocreationLocalServiceImpl, addCocreation method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(serviceContext.getUserId());

		Date now = new Date();

		long cocreationId = counterLocalService.increment();

		Cocreation cocreation = cocreationPersistence.create(cocreationId);

		cocreation.setUuid(serviceContext.getUuid());
		cocreation.setUserId(serviceContext.getUserId());
		cocreation.setGroupId(groupId);
		cocreation.setCompanyId(user.getCompanyId());
		cocreation.setUserName(user.getFullName());
		cocreation.setCreateDate(serviceContext.getCreateDate(now));
		cocreation.setModifiedDate(serviceContext.getModifiedDate(now));
		
		cocreation.setCocreationId(cocreationId);
		cocreation.setChallengeId(challengeId);
		cocreation.setTitle(title);
		cocreation.setDescription(description);
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("challengeId: " +challengeId);
		_log.info("title: " +title);
		_log.info("description: " +description);
		
		cocreation = cocreationPersistence.update(cocreation);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
                groupId, cocreation.getCreateDate(), cocreation.getModifiedDate(),
                Cocreation.class.getName(), cocreationId, cocreation.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, null, null, null, null,
                null, 0, 0, null);
		
		_log.info("generated cocreation");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		//set permission
		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
				Cocreation.class.getName(), cocreationId, false, true, true);

		_log.info("generated permission");
		return cocreation;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Cocreation updateCocreation(
			long cocreationId,
			long challengeId,
			String title,
			String description,
	        Date startDate,
	        Date endDate,
	        boolean active,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("CocreationLocalServiceImpl, updateCocreation method");

		Date now = new Date();

		Cocreation cocreation =
			cocreationPersistence.findByPrimaryKey(cocreationId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		cocreation.setUserId(serviceContext.getUserId());
		cocreation.setUserName(user.getFullName());
		cocreation.setModifiedDate(serviceContext.getModifiedDate(now));
		
		cocreation.setChallengeId(challengeId);
		cocreation.setTitle(title);
		cocreation.setDescription(description);
		
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("challengeId: " +challengeId);
		_log.info("title: " +title);
		_log.info("description: " +description);
	
		cocreation = cocreationPersistence.update(cocreation);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
	              serviceContext.getScopeGroupId(),
	              cocreation.getCreateDate(), cocreation.getModifiedDate(),
	              Cocreation.class.getName(), cocreationId, cocreation.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              cocreation.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, null, null,
	              null, null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		_log.info("generated assetEntry");
	
		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		return cocreation;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Cocreation deleteCocreation(Cocreation cocreation) {
		
		_log.info("CocreationLocalServiceImpl, deleteCocreation method");
		
		cocreationPersistence.remove(cocreation);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				Cocreation.class.getName(), cocreation.getCocreationId());
		
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

		return cocreation;
	}
	
	@Indexable(type = IndexableType.DELETE)
    public Cocreation deleteCocreation(long cocreationId, long userId) throws PortalException {
		_log.info("deleteCocreation method");
		_log.info("cocreationId "+cocreationId);
		_log.info("userId "+userId);
		
		Cocreation cocreation = cocreationPersistence.findByPrimaryKey(cocreationId);

        return deleteCocreation(cocreation);
    }

	public Cocreation deleteCocreation(long cocreationId) throws PortalException {

		Cocreation cocreation = cocreationPersistence.findByPrimaryKey(cocreationId);

		return deleteCocreation(cocreation);
	}
	
	public List<Cocreation> getCocreationsByUserId(long userId, long groupId) {
		return cocreationPersistence.findByUserId(userId, groupId);
	}

	public List<Cocreation> getCocreationsByUserId(long userId, long groupId,
			int start, int end) throws SystemException {
		return cocreationPersistence.findByUserId(userId, groupId, start, end);
	}

	public List<Cocreation> getCocreationsByUserId(long userId, long groupId,
			int start, int end, OrderByComparator<Cocreation> obc) {
		return cocreationPersistence.findByUserId(userId, groupId, start, end, obc);
	}

	public Cocreation getCocreation(long cocreationId) throws PortalException {
		return cocreationPersistence.findByPrimaryKey(cocreationId);
	}

	public int getCocreationsCountByUserId(long userId, long groupId){
		return cocreationPersistence.countByUserId(userId, groupId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CocreationLocalServiceImpl.class);
}