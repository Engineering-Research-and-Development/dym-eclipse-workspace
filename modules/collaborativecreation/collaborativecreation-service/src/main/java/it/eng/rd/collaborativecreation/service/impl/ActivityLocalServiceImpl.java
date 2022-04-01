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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.collaborativecreation.model.Activity;
import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.service.base.ActivityLocalServiceBaseImpl;

/**
 * The implementation of the activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.ActivityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see ActivityLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Activity",
	service = AopService.class
)
public class ActivityLocalServiceImpl extends ActivityLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Activity addActivity(
			long cocreationId,
			String description,
			Date expirationDate,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("ActivityLocalServiceImpl - addActivity method");

		long activityId = counterLocalService.increment();

		Activity activity = activityPersistence.create(activityId);
		activity.setCocreationId(cocreationId);
		activity.setDescription(description);
		activity.setExpirationDate(expirationDate);
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("description: " +description);
		_log.info("expirationDate: " +expirationDate);
		
		activity = activityPersistence.update(activity);
		
		return activity;
	}
	
	public Activity deleteActivity(long activityId) throws PortalException {
		_log.info("ActivityLocalServiceImpl - deleteActivity method");
		_log.info("activityId "+activityId);

		Activity activity = activityPersistence.findByPrimaryKey(activityId);

		return deleteActivity(activity);
	}
	
	public List<Activity> getActivitiesByCocreationId(long cocreationId) throws PortalException {
		_log.info("ActivityLocalServiceImpl - getActivitiesByCocreationId method");
		_log.info("cocreationId "+cocreationId);
	  
	    return activityPersistence.findByCocreation(cocreationId);
	}
	 
	
	private static final Log _log = LogFactoryUtil.getLog(ActivityLocalServiceImpl.class);
}