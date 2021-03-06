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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.rd.collaborativecreation.model.Activity;
import it.eng.rd.collaborativecreation.service.ActivityLocalService;
import it.eng.rd.collaborativecreation.service.ActivityLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.persistence.ActivityPersistence;
import it.eng.rd.collaborativecreation.service.persistence.CategoryPersistence;
import it.eng.rd.collaborativecreation.service.persistence.ChallengePersistence;
import it.eng.rd.collaborativecreation.service.persistence.CocreationPersistence;
import it.eng.rd.collaborativecreation.service.persistence.CocreatorPersistence;
import it.eng.rd.collaborativecreation.service.persistence.HashtagPersistence;
import it.eng.rd.collaborativecreation.service.persistence.LocationPersistence;
import it.eng.rd.collaborativecreation.service.persistence.QuestionPersistence;
import it.eng.rd.collaborativecreation.service.persistence.TaskPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the activity local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.rd.collaborativecreation.service.impl.ActivityLocalServiceImpl}.
 * </p>
 *
 * @author ENGRD
 * @see it.eng.rd.collaborativecreation.service.impl.ActivityLocalServiceImpl
 * @generated
 */
public abstract class ActivityLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ActivityLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ActivityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ActivityLocalServiceUtil</code>.
	 */

	/**
	 * Adds the activity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Activity addActivity(Activity activity) {
		activity.setNew(true);

		return activityPersistence.update(activity);
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	@Override
	@Transactional(enabled = false)
	public Activity createActivity(long activityId) {
		return activityPersistence.create(activityId);
	}

	/**
	 * Deletes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws PortalException if a activity with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Activity deleteActivity(long activityId) throws PortalException {
		return activityPersistence.remove(activityId);
	}

	/**
	 * Deletes the activity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Activity deleteActivity(Activity activity) {
		return activityPersistence.remove(activity);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Activity.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return activityPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return activityPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return activityPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return activityPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return activityPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Activity fetchActivity(long activityId) {
		return activityPersistence.fetchByPrimaryKey(activityId);
	}

	/**
	 * Returns the activity with the primary key.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws PortalException if a activity with the primary key could not be found
	 */
	@Override
	public Activity getActivity(long activityId) throws PortalException {
		return activityPersistence.findByPrimaryKey(activityId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(activityLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Activity.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			activityLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Activity.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("activityId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(activityLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Activity.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return activityPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return activityLocalService.deleteActivity((Activity)persistedModel);
	}

	public BasePersistence<Activity> getBasePersistence() {
		return activityPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return activityPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of activities
	 */
	@Override
	public List<Activity> getActivities(int start, int end) {
		return activityPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	@Override
	public int getActivitiesCount() {
		return activityPersistence.countAll();
	}

	/**
	 * Updates the activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Activity updateActivity(Activity activity) {
		return activityPersistence.update(activity);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ActivityLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		activityLocalService = (ActivityLocalService)aopProxy;

		_setLocalServiceUtilService(activityLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ActivityLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Activity.class;
	}

	protected String getModelClassName() {
		return Activity.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = activityPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		ActivityLocalService activityLocalService) {

		try {
			Field field = ActivityLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, activityLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ActivityLocalService activityLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}