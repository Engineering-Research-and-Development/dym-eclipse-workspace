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

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.service.base.ChallengeLocalServiceBaseImpl;

/**
 * The implementation of the challenge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.ChallengeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see ChallengeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Challenge",
	service = AopService.class
)
public class ChallengeLocalServiceImpl extends ChallengeLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Challenge addChallenge(
			String title,
			String description,
	        Date startDate,
	        Date endDate,
	        boolean active,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("ChallengeLocalServiceImpl, addChallenge method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(serviceContext.getUserId());

		Date now = new Date();

		long challengeId = counterLocalService.increment();

		Challenge challenge = challengePersistence.create(challengeId);

		challenge.setUuid(serviceContext.getUuid());
		challenge.setUserId(serviceContext.getUserId());
		challenge.setGroupId(groupId);
		challenge.setCompanyId(user.getCompanyId());
		challenge.setUserName(user.getFullName());
		challenge.setCreateDate(serviceContext.getCreateDate(now));
		challenge.setModifiedDate(serviceContext.getModifiedDate(now));
		
		challenge.setChallengeId(challengeId);
		challenge.setTitle(title);
		challenge.setDescription(description);
		challenge.setStartDate(startDate);
		challenge.setEndDate(endDate);
		challenge.setActive(active);
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("challengeId: " +challengeId);
		_log.info("title: " +title);
		_log.info("description: " +description);
		_log.info("startDate: " +startDate);
		_log.info("endDate: " +endDate);
		_log.info("active: " +active);
		
		challenge = challengePersistence.update(challenge);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
                groupId, challenge.getCreateDate(), challenge.getModifiedDate(),
                Challenge.class.getName(), challengeId, challenge.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, null, null, null, null,
                null, 0, 0, null);
		
		_log.info("generated challenge");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		//set permission
		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
			    Challenge.class.getName(), challengeId, false, true, true);

		_log.info("generated permission");
		return challenge;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Challenge updateChallenge(
			long challengeId,
			String title,
			String description,
	        Date startDate,
	        Date endDate,
	        boolean active,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("ChallengeLocalServiceImpl, updateChallenge method");

		Date now = new Date();

		Challenge challenge =
			challengePersistence.findByPrimaryKey(challengeId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		challenge.setUserId(serviceContext.getUserId());
		challenge.setUserName(user.getFullName());
		challenge.setModifiedDate(serviceContext.getModifiedDate(now));
		
		challenge.setTitle(title);
		challenge.setDescription(description);
		challenge.setStartDate(startDate);
		challenge.setEndDate(endDate);
		challenge.setActive(active);
		
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("challengeId: " +challengeId);
		_log.info("title: " +title);
		_log.info("description: " +description);
		_log.info("startDate: " +startDate);
		_log.info("endDate: " +endDate);
		_log.info("active: " +active);

		challenge = challengePersistence.update(challenge);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
	              serviceContext.getScopeGroupId(),
	              challenge.getCreateDate(), challenge.getModifiedDate(),
	              Challenge.class.getName(), challengeId, challenge.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              challenge.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, null, null,
	              null, null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		_log.info("generated assetEntry");
	
		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated assetLink");
		
		return challenge;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Challenge deleteChallenge(Challenge challenge) {
		
		_log.info("ChallengeLocalServiceImpl, deleteChallenge method");
		
		challengePersistence.remove(challenge);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                Challenge.class.getName(), challenge.getChallengeId());
		
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

		return challenge;
	}
	
	@Indexable(type = IndexableType.DELETE)
    public Challenge deleteChallenge(long challengeId, long userId) throws PortalException {
		_log.info("deleteChallenge method");
		_log.info("challengeId "+challengeId);
		_log.info("userId "+userId);
		
		Challenge challenge = challengePersistence.findByPrimaryKey(challengeId);

        return deleteChallenge(challenge);
    }

	public Challenge deleteChallenge(long challengeId) throws PortalException {

		Challenge challenge = challengePersistence.findByPrimaryKey(challengeId);

		return deleteChallenge(challenge);
	}
	
	public List<Challenge> getChallengesByUserId(long userId, long groupId) {
		return challengePersistence.findByUserId(userId, groupId);
	}

	public List<Challenge> getChallengesByUserId(long userId, long groupId,
			int start, int end) throws SystemException {
		return challengePersistence.findByUserId(userId, groupId, start, end);
	}

	public List<Challenge> getChallengesByUserId(long userId, long groupId,
			int start, int end, OrderByComparator<Challenge> obc) {
		return challengePersistence.findByUserId(userId, groupId, start, end, obc);
	}

	public Challenge getChallenge(long challengeId) throws PortalException {
		return challengePersistence.findByPrimaryKey(challengeId);
	}

	public int getChallengesCountByUserId(long userId, long groupId){
		return challengePersistence.countByUserId(userId, groupId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ChallengeLocalServiceImpl.class);
}