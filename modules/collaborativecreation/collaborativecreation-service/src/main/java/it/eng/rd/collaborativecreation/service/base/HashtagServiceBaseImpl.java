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

package it.eng.rd.collaborativecreation.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.rd.collaborativecreation.model.Hashtag;
import it.eng.rd.collaborativecreation.service.HashtagService;
import it.eng.rd.collaborativecreation.service.HashtagServiceUtil;
import it.eng.rd.collaborativecreation.service.persistence.ActivityPersistence;
import it.eng.rd.collaborativecreation.service.persistence.CategoryPersistence;
import it.eng.rd.collaborativecreation.service.persistence.ChallengePersistence;
import it.eng.rd.collaborativecreation.service.persistence.CocreationPersistence;
import it.eng.rd.collaborativecreation.service.persistence.CocreatorPersistence;
import it.eng.rd.collaborativecreation.service.persistence.HashtagPersistence;
import it.eng.rd.collaborativecreation.service.persistence.LocationPersistence;
import it.eng.rd.collaborativecreation.service.persistence.QuestionPersistence;
import it.eng.rd.collaborativecreation.service.persistence.TaskPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the hashtag remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.rd.collaborativecreation.service.impl.HashtagServiceImpl}.
 * </p>
 *
 * @author ENGRD
 * @see it.eng.rd.collaborativecreation.service.impl.HashtagServiceImpl
 * @generated
 */
public abstract class HashtagServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, HashtagService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>HashtagService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>HashtagServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			HashtagService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		hashtagService = (HashtagService)aopProxy;

		_setServiceUtilService(hashtagService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return HashtagService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Hashtag.class;
	}

	protected String getModelClassName() {
		return Hashtag.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = hashtagPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(HashtagService hashtagService) {
		try {
			Field field = HashtagServiceUtil.class.getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, hashtagService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ActivityPersistence activityPersistence;

	@Reference
	protected CategoryPersistence categoryPersistence;

	@Reference
	protected ChallengePersistence challengePersistence;

	@Reference
	protected CocreationPersistence cocreationPersistence;

	@Reference
	protected CocreatorPersistence cocreatorPersistence;

	@Reference
	protected it.eng.rd.collaborativecreation.service.HashtagLocalService
		hashtagLocalService;

	protected HashtagService hashtagService;

	@Reference
	protected HashtagPersistence hashtagPersistence;

	@Reference
	protected LocationPersistence locationPersistence;

	@Reference
	protected QuestionPersistence questionPersistence;

	@Reference
	protected TaskPersistence taskPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}