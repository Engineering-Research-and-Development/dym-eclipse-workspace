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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.collaborativecreation.exception.NoSuchCocreatorException;
import it.eng.rd.collaborativecreation.model.Cocreator;
import it.eng.rd.collaborativecreation.service.base.CocreatorLocalServiceBaseImpl;

/**
 * The implementation of the cocreator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.CocreatorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see CocreatorLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Cocreator",
	service = AopService.class
)
public class CocreatorLocalServiceImpl extends CocreatorLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Cocreator addCocreator(
			long cocreationId,
			long userId,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("CocreatorLocalServiceImpl - addCocreator method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();
		
		long cocreatorId = counterLocalService.increment();

		Cocreator cocreator = cocreatorPersistence.create(cocreatorId);

		cocreator.setUuid(serviceContext.getUuid());
		cocreator.setUserId(userId);
		cocreator.setGroupId(groupId);
		cocreator.setCompanyId(user.getCompanyId());
		cocreator.setUserName(user.getFullName());
		
		cocreator.setCocreationId(cocreationId);
		cocreator.setCocreatorId(cocreatorId);
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("cocreatorId: " +cocreatorId);
		
		cocreator = cocreatorPersistence.update(cocreator);
		
		return cocreator;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Cocreator updateCocreator(
			long cocreationId,
			long cocreatorId,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("CocreatorLocalServiceImpl - updateCocreator method");

		Date now = new Date();

		Cocreator cocreator = cocreatorPersistence.findByPrimaryKey(cocreatorId);
		
		User user = userLocalService.getUserById(serviceContext.getUserId());

		cocreator.setUserId(serviceContext.getUserId());
		cocreator.setUserName(user.getFullName());
		
		cocreator.setCocreationId(cocreationId);
		
		_log.info("userId: " +serviceContext.getUserId());
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		
		_log.info("cocreationId: " +cocreationId);
		_log.info("cocreatorId: " +cocreatorId);
		
		cocreator = cocreatorPersistence.update(cocreator);
		
		return cocreator;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Cocreator deleteCocreator(Cocreator cocreator) {
		
		_log.info("CocreatorLocalServiceImpl - deleteCocreator method");
		
		cocreatorPersistence.remove(cocreator);
		
		return cocreator;
	}
	
	@Indexable(type = IndexableType.DELETE)
    public Cocreator deleteCocreator(long cocreatorId) throws PortalException {
		_log.info("deleteCocreator method");
		_log.info("cocreatorId "+cocreatorId);
		
		Cocreator cocreator = cocreatorPersistence.findByPrimaryKey(cocreatorId);

        return deleteCocreator(cocreator);
    }
	
	public void deleteCocreatorByCocreatorId(long cocreatorId) throws NoSuchCocreatorException {
		_log.info("CocreatorLocalServiceImpl - deleteCocreatorByCocreatorId method");
		_log.info("userId "+cocreatorId);
		
		Cocreator cocreator = cocreatorPersistence.findByPrimaryKey(cocreatorId);
	
		deleteCocreator(cocreator);		
	}
	
	public List<Cocreator> getCocreatorsByUserId(long userId) {
		return cocreatorPersistence.findByUserId(userId);
	}

	public List<Cocreator> getCocreatorsByUserId(long userId,
			int start, int end) throws SystemException {
		return cocreatorPersistence.findByUserId(userId, start, end);
	}

	public List<Cocreator> getCocreatorsByUserId(long userId, 
			int start, int end, OrderByComparator<Cocreator> obc) {
		return cocreatorPersistence.findByUserId(userId, start, end, obc);
	}

	public List<Cocreator> getCocreatorsByCocreationId(long cocreationId) throws PortalException {
		_log.info("CocreatorLocalServiceImpl - getCocreatorsByCocreationId method");
		_log.info("cocreationId "+cocreationId);
		
		return cocreatorPersistence.findByCocreationId(cocreationId);
	}
	
	public Cocreator getCocreator(long cocreatorId) throws PortalException {
		return cocreatorPersistence.findByPrimaryKey(cocreatorId);
	}

	public int getCocreatorsCountByUserId(long userId){
		return cocreatorPersistence.countByUserId(userId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CocreatorLocalServiceImpl.class);
}