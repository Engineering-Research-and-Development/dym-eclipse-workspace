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
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.model.Cocreator;
import it.eng.rd.collaborativecreation.service.ChallengeLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CocreationLocalServiceUtil;
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
			long cocreatorId,
			String req,
			String message,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("CocreationLocalServiceImpl - addCocreation method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(cocreatorId);

		Date now = new Date();

		long cocreationId = counterLocalService.increment();

		Cocreation cocreation = cocreationPersistence.create(cocreationId);

		cocreation.setUuid(serviceContext.getUuid());
		cocreation.setUserId(cocreatorId);
		cocreation.setGroupId(groupId);
		cocreation.setCompanyId(user.getCompanyId());
		cocreation.setUserName(user.getFullName());
		cocreation.setCreateDate(serviceContext.getCreateDate(now));
		cocreation.setModifiedDate(serviceContext.getModifiedDate(now));
		
		cocreation.setCocreationId(cocreationId);
		cocreation.setChallengeId(challengeId);
		cocreation.setRequest(req);
		cocreation.setMessage(message);
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +cocreatorId);
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("challengeId: " +challengeId);
		_log.info("request: " +req);
		_log.info("message: " +message);
		
		cocreation = cocreationPersistence.update(cocreation);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
                groupId, cocreation.getCreateDate(), cocreation.getModifiedDate(),
                Cocreation.class.getName(), cocreationId, cocreation.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, null, null, null, null,
                null, 0, 0, null);
		_log.info("generated cocreation");

		return cocreation;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Cocreation updateCocreation(
			long cocreationId,
			String title,
			String description,
			boolean completed,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("CocreationLocalServiceImpl - updateCocreation method");

		Date now = new Date();

		Cocreation cocreation = cocreationPersistence.findByPrimaryKey(cocreationId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		cocreation.setUserId(serviceContext.getUserId());
		/* cocreation.setUserName(user.getFullName()); */
		cocreation.setModifiedDate(serviceContext.getModifiedDate(now));
		
		cocreation.setTitle(title);
		cocreation.setDescription(description);
		cocreation.setCompleted(completed);
		
		if (completed == true) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date completionDate;
			try {
				completionDate = dateFormat.parse(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				cocreation.setCompletionDate(completionDate);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		}
		
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("title: " +title);
		_log.info("description: " +description);
		_log.info("completed: " +completed);
		
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
	
		return cocreation;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Cocreation deleteCocreation(Cocreation cocreation) {
		
		_log.info("CocreationLocalServiceImpl - deleteCocreation method");
		
		cocreationPersistence.remove(cocreation);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				Cocreation.class.getName(), cocreation.getCocreationId());
		
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
	
	@Indexable(type = IndexableType.DELETE)
    public void deleteCocreationsByChallengeId(long challengeId, long companyId) throws PortalException {
		_log.info("CocreationLocalServiceImpl - deleteCocreationsByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		List<Cocreation> cocreations = cocreationPersistence.findByChallengeId(challengeId);
		
		Iterator<Cocreation> cocreationsIt = cocreations.iterator();
		while(cocreationsIt.hasNext()){
			Cocreation cocreation = cocreationsIt.next();
			List<Cocreator> cocreators = cocreatorPersistence.findByCocreationId(cocreation.getCocreationId());
			deleteCocreation(cocreation);
			
			/*Rimuovo il ruolo relativo alla co-creazione*/ 
			Role role = RoleLocalServiceUtil.getRole(companyId, "Cocreation_"+cocreation.getCocreationId());
			RoleLocalServiceUtil.deleteRole(role.getRoleId()); 
		}	
    }

	public Cocreation deleteCocreationByCocreationId(long cocreationId) throws PortalException {
		_log.info("CocreationLocalServiceImpl - deleteCocreationByCocreationId method");
		_log.info("cocreationId  "+cocreationId);
		
		Cocreation cocreation = cocreationPersistence.findByPrimaryKey(cocreationId);

		return deleteCocreation(cocreation);
	}
	
	public List<Cocreation> getCocreationsBySearchGroupId(String keywords, long groupId, boolean completed) throws PortalException, SystemException, ClassNotFoundException {
		_log.info("CocreationLocalServiceImpl - getCocreationsBySearchGroupId method");
		_log.info("keywords "+keywords);
		_log.info("groupId "+groupId);
		_log.info("completed "+completed);
		
		List<Cocreation> cocreationsList  = new ArrayList<Cocreation>();
		
		Criterion cr1 = RestrictionsFactoryUtil.ilike("title", "%"+keywords+"%");
		Criterion cr2 = RestrictionsFactoryUtil.ilike("description", "%"+keywords+"%");
		Criterion cr3 = RestrictionsFactoryUtil.ilike("userName", "%"+keywords+"%");
		Criterion cr4 = RestrictionsFactoryUtil.eq("groupId", groupId);
		Criterion cr5 = RestrictionsFactoryUtil.eq("completed", completed);
	
		DynamicQuery cocreationQuery = CocreationLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.or(cr1, cr2), cr3)).add(RestrictionsFactoryUtil.and(cr4, cr5));
	    
		List<Cocreation> dynamicCocreationsList = CocreationLocalServiceUtil.dynamicQuery(cocreationQuery);
	    
	    for (int i = 0; i < dynamicCocreationsList.size(); i++){
	    	cocreationsList.add(dynamicCocreationsList.get(i));
	    }
	    return cocreationsList;
	}
	
	public List<Cocreation> getCocreationsBySearchUserId(String keywords, long userId, long groupId, boolean completed) throws PortalException, SystemException, ClassNotFoundException {
		_log.info("CocreationLocalServiceImpl - getCocreationsBySearchCocreatorId method");
		_log.info("keywords "+keywords);
		_log.info("userId "+userId);
		_log.info("groupId "+groupId);
		_log.info("completed "+completed);
		
		List<Cocreation> cocreationsList  = new ArrayList<Cocreation>();
		
		Criterion cr1 = RestrictionsFactoryUtil.ilike("title", "%"+keywords+"%");
		Criterion cr2 = RestrictionsFactoryUtil.ilike("description", "%"+keywords+"%");
		Criterion cr3 = RestrictionsFactoryUtil.eq("userName", UserLocalServiceUtil.getUser(userId).getFullName());
		Criterion cr4 = RestrictionsFactoryUtil.eq("groupId", groupId);
		Criterion cr5 = RestrictionsFactoryUtil.eq("completed", completed);
	
		DynamicQuery cocreationQuery = CocreationLocalServiceUtil.dynamicQuery().add(RestrictionsFactoryUtil.or(cr1, cr2)).add(RestrictionsFactoryUtil.and(cr3, cr4)).add(cr5);	
	    
		List<Cocreation> dynamicCocreationsList = CocreationLocalServiceUtil.dynamicQuery(cocreationQuery);
	    
	    for (int i = 0; i < dynamicCocreationsList.size(); i++){
	    	cocreationsList.add(dynamicCocreationsList.get(i));
	    }
	    return cocreationsList;
	}
	
	public List<Cocreation> getCocreationsByGroupId(long groupId, boolean completed) throws SystemException {
		_log.info("CocreationLocalServiceImpl - getCocreationsByGroupId method");
		_log.info("groupId  "+groupId);
		
		return cocreationPersistence.findByGroupId(groupId, completed);
	}
	
    public List<Cocreation> getCocreationsByChallengeId(long challengeId) throws PortalException {
    	_log.info("CocreationLocalServiceImpl - getCocreationsByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		return cocreationPersistence.findByChallengeId(challengeId);
    }
	
    public List<Cocreation> getCocreationsByCocreatorId(long userId, long groupId, boolean completed) {
    	_log.info("CocreationLocalServiceImpl - getCocreationsByUserId method");
		_log.info("userId "+userId);
		_log.info("groupId "+groupId);
		
    	List<Cocreation> cocreations = cocreationPersistence.findByGroupId(groupId, completed);
    	List<Cocreation> myCocreations = new ArrayList<Cocreation>();
    	
    	Iterator<Cocreation> cocreationsIt = cocreations.iterator();
		while(cocreationsIt.hasNext()){
			Cocreation cocreation = cocreationsIt.next();
			List<Cocreator> cocreators = cocreatorPersistence.findByCocreationId(cocreation.getCocreationId());
			Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
			while(cocreatorsIt.hasNext()){
				Cocreator cocreator = cocreatorsIt.next();
				if (cocreator.getUserId() == userId){
					myCocreations.add(cocreation);
				}
			}
		}	
		return myCocreations;
	}
    
	public List<Cocreation> getCocreationsByUserId(long userId, long groupId) {
		_log.info("CocreationLocalServiceImpl - getCocreationsByUserId method");
		_log.info("userId "+userId);
		_log.info("groupId "+groupId);
		
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