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
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.service.ChallengeLocalServiceUtil;
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
			String desiredOutcome,
			String additionalInformation,
	        Date startDate,
	        Date endDate,
	        boolean active,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("ChallengeLocalServiceImpl - addChallenge method");

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
		challenge.setDesiredOutcome(desiredOutcome);
		challenge.setAdditionalInformation(additionalInformation);
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
		_log.info("desiredOutcome: " +desiredOutcome);
		_log.info("additionalInformation: " +additionalInformation);
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
		
		/*
		 * resourceLocalService.addResources(user.getCompanyId(), groupId,
		 * serviceContext.getUserId(), Challenge.class.getName(), challengeId, false,
		 * true, true);
		 */
		
		return challenge;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Challenge updateChallenge(
			long challengeId,
			String title,
			String description,
			String desiredOutcome,
			String additionalInformation,
	        Date startDate,
	        Date endDate,
	        boolean active,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("ChallengeLocalServiceImpl - updateChallenge method");

		Date now = new Date();

		Challenge challenge = challengePersistence.findByPrimaryKey(challengeId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		challenge.setUserId(serviceContext.getUserId());
		challenge.setUserName(user.getFullName());
		challenge.setModifiedDate(serviceContext.getModifiedDate(now));
		challenge.setTitle(title);
		challenge.setDescription(description);
		challenge.setDesiredOutcome(desiredOutcome);
		challenge.setAdditionalInformation(additionalInformation);
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
		_log.info("desiredOutcome: " +desiredOutcome);
		_log.info("additionalInformation: " +additionalInformation);
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
		
		return challenge;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Challenge deleteChallenge(Challenge challenge) {
		
		_log.info("ChallengeLocalServiceImpl - deleteChallenge method");
		
		challengePersistence.remove(challenge);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                Challenge.class.getName(), challenge.getChallengeId());
		
		_log.info("removed assetEntry");
		
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
		
		/*
		 * try { ResourceLocalServiceUtil.deleteResource( challenge.getCompanyId(),
		 * Challenge.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
		 * challenge.getPrimaryKey()); } catch (PortalException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		return challenge;
	}

	public Challenge deleteChallenge(long challengeId) throws PortalException {
		_log.info("ChallengeLocalServiceImpl - deleteChallenge method");
		_log.info("challengeId "+challengeId);

		Challenge challenge = challengePersistence.findByPrimaryKey(challengeId);

		return deleteChallenge(challenge);
	}
	
	public List<Challenge> getChallengesBySearch(String keywords) throws PortalException, SystemException, ClassNotFoundException {
		_log.info("ChallengeLocalServiceImpl - getChallengesBySearch method");
		_log.info("keywords "+keywords);
		
		List<Challenge> challengesList  = new ArrayList<Challenge>();
		
		Criterion cr1 = RestrictionsFactoryUtil.ilike("title", "%"+keywords+"%");
		Criterion cr2 = RestrictionsFactoryUtil.ilike("description", "%"+keywords+"%");
		Criterion cr3 = RestrictionsFactoryUtil.ilike("userName", "%"+keywords+"%");
	
		DynamicQuery challengeQuery1 = ChallengeLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.or(cr1, cr2));;
		DynamicQuery challengeQuery2 = ChallengeLocalServiceUtil.dynamicQuery().add(cr3);;
		
	    List<Challenge> challengesList1 = ChallengeLocalServiceUtil.dynamicQuery(challengeQuery1);
	    List<Challenge> challengesList2 = ChallengeLocalServiceUtil.dynamicQuery(challengeQuery2);
	   
	    for (int i = 0; i < challengesList1.size(); i++){
	    	challengesList.add(challengesList1.get(i));
	    }
	    for (int i = 0; i < challengesList2.size(); i++){
	    	challengesList.add(challengesList2.get(i));
	    }
	    return challengesList;
	}
	
	public Challenge getChallengeByCocreationId(long cocreationId, long groupId) {
		_log.info("ChallengeLocalServiceImpl - getChallengeByCocreationId method");
		_log.info("cocreationId "+cocreationId);
		_log.info("groupId "+groupId);
		
		List<Challenge> challenges = challengePersistence.findByGroupId(groupId);
		Challenge returnChallenge = challenges.get(0);
		
		Iterator<Challenge> challengesIt = challenges.iterator();
		while(challengesIt.hasNext()){
			Challenge challenge = challengesIt.next();	
			List<Cocreation> cocreations = cocreationPersistence.findByChallengeId(challenge.getChallengeId());
			Iterator<Cocreation> cocreationsIt = cocreations.iterator();
			while(cocreationsIt.hasNext()){
				Cocreation cocreation = cocreationsIt.next();
				if (cocreation.getCocreationId() == cocreationId){
					return challenge;
				}
			}
		}	
		return returnChallenge;
	}
	
	
	public List<Challenge> getChallengesByActive(long groupId, boolean active) {
		_log.info("ChallengeLocalServiceImpl - getChallengesByActive method");
		_log.info("groupId "+groupId);
		_log.info("active "+active);
		
		Calendar calendar = Calendar.getInstance();
		Date nowDate = calendar.getTime();
	    List<Challenge> challengesList = new ArrayList<Challenge>();
	    for (int i = 0; i < challengePersistence.findByGroupId(groupId).size(); i++){
	    	if (challengePersistence.findByGroupId(groupId).get(i).getEndDate().after(nowDate) == active){
	    		challengesList.add(challengePersistence.findByGroupId(groupId).get(i));
	    	}
	    }
	    
	    /* return challengePersistence.findByActive(groupId, active); */
	    return challengesList;
	} 
	
	public List<Challenge> getChallengesByGroupId(long groupId) {
		return challengePersistence.findByGroupId(groupId);
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
	
	public double getAverageScore(long challengeId) {
		_log.info("ChallengeLocalServiceImpl - getAverageScore method");
		_log.info("challengeId "+challengeId);
		
		RatingsStats ratingsStats;
		try {
			ratingsStats = RatingsStatsLocalServiceUtil.getStats(Challenge.class.getName(), challengeId);
		} catch (PortalException e) {
			return 0.0;
		}
	    return ratingsStats.getAverageScore();
	} 
	
	private static final Log _log = LogFactoryUtil.getLog(ChallengeLocalServiceImpl.class);
}