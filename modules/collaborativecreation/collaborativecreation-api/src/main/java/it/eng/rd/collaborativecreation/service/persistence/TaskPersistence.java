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

package it.eng.rd.collaborativecreation.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.rd.collaborativecreation.exception.NoSuchTaskException;
import it.eng.rd.collaborativecreation.model.Task;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see TaskUtil
 * @generated
 */
@ProviderType
public interface TaskPersistence extends BasePersistence<Task> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskUtil} to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByTask(long taskId);

	/**
	 * Returns a range of all the tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByTask(long taskId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByTask(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByTask(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByTask_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByTask_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByTask_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByTask_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Removes all the tasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTask(long taskId);

	/**
	 * Returns the number of tasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching tasks
	 */
	public int countByTask(long taskId);

	/**
	 * Returns all the tasks where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByCocreation(
		long userId, long cocreationId);

	/**
	 * Returns a range of all the tasks where userId = &#63; and cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByCocreation(
		long userId, long cocreationId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByCocreation(
		long userId, long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByCocreation(
		long userId, long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByCocreation_First(
			long userId, long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByCocreation_First(
		long userId, long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByCocreation_Last(
			long userId, long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByCocreation_Last(
		long userId, long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByCocreation_PrevAndNext(
			long taskId, long userId, long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where userId = &#63; and cocreationId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 */
	public void removeByCocreation(long userId, long cocreationId);

	/**
	 * Returns the number of tasks where userId = &#63; and cocreationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param cocreationId the cocreation ID
	 * @return the number of matching tasks
	 */
	public int countByCocreation(long userId, long cocreationId);

	/**
	 * Caches the task in the entity cache if it is enabled.
	 *
	 * @param task the task
	 */
	public void cacheResult(Task task);

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public void cacheResult(java.util.List<Task> tasks);

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	public Task create(long taskId);

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task remove(long taskId) throws NoSuchTaskException;

	public Task updateImpl(Task task);

	/**
	 * Returns the task with the primary key or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task findByPrimaryKey(long taskId) throws NoSuchTaskException;

	/**
	 * Returns the task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task, or <code>null</code> if a task with the primary key could not be found
	 */
	public Task fetchByPrimaryKey(long taskId);

	/**
	 * Returns all the tasks.
	 *
	 * @return the tasks
	 */
	public java.util.List<Task> findAll();

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	public java.util.List<Task> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tasks
	 */
	public java.util.List<Task> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tasks
	 */
	public java.util.List<Task> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tasks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	public int countAll();

}