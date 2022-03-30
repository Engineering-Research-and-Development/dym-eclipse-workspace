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

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.model.Cocreator;
import it.eng.rd.collaborativecreation.model.Task;
import it.eng.rd.collaborativecreation.service.CocreationLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CocreatorLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.base.TaskLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.TaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see TaskLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Task addTask(
			long cocreationId,
			long userId,
			String description,
			Date expirationDate,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("TaskLocalServiceImpl - addTask method");

		long taskId = counterLocalService.increment();

		Task task = taskPersistence.create(taskId);
		task.setCocreationId(cocreationId);
		task.setUserId(userId);
		task.setDescription(description);
		task.setExpirationDate(expirationDate);
		
		_log.info("userId: " +userId);
		_log.info("cocreationId: " +cocreationId);
		_log.info("description: " +description);
		_log.info("expirationDate: " +expirationDate);
		
		task = taskPersistence.update(task);
		
		return task;
	}
	
	
	public List<Task> getTasksByCocreationId(long cocreationId, long userId) throws PortalException {
		_log.info("TaskLocalServiceImpl - getTasksByCocreationId method");
		_log.info("cocreationId "+cocreationId);
		_log.info("userId "+userId);
	  
		return taskPersistence.findByCocreation(userId, cocreationId);
	}
	 
	
	private static final Log _log = LogFactoryUtil.getLog(TaskLocalServiceImpl.class);
}