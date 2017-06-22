/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.event.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.event.model.Target;

/**
 * The persistence interface for the target service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TargetPersistenceImpl
 * @see TargetUtil
 * @generated
 */
public interface TargetPersistence extends BasePersistence<Target> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TargetUtil} to access the target persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the targets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the targets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of targets
	* @param end the upper bound of the range of targets (not inclusive)
	* @return the range of matching targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the targets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of targets
	* @param end the upper bound of the range of targets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first target in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching target
	* @throws com.rivetlogic.event.NoSuchTargetException if a matching target could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTargetException;

	/**
	* Returns the first target in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching target, or <code>null</code> if a matching target could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last target in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching target
	* @throws com.rivetlogic.event.NoSuchTargetException if a matching target could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTargetException;

	/**
	* Returns the last target in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching target, or <code>null</code> if a matching target could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the targets before and after the current target in the ordered set where groupId = &#63;.
	*
	* @param targetId the primary key of the current target
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next target
	* @throws com.rivetlogic.event.NoSuchTargetException if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target[] findByGroupId_PrevAndNext(
		long targetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTargetException;

	/**
	* Removes all the targets where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of targets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching targets
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the target in the entity cache if it is enabled.
	*
	* @param target the target
	*/
	public void cacheResult(com.rivetlogic.event.model.Target target);

	/**
	* Caches the targets in the entity cache if it is enabled.
	*
	* @param targets the targets
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.event.model.Target> targets);

	/**
	* Creates a new target with the primary key. Does not add the target to the database.
	*
	* @param targetId the primary key for the new target
	* @return the new target
	*/
	public com.rivetlogic.event.model.Target create(long targetId);

	/**
	* Removes the target with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param targetId the primary key of the target
	* @return the target that was removed
	* @throws com.rivetlogic.event.NoSuchTargetException if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target remove(long targetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTargetException;

	public com.rivetlogic.event.model.Target updateImpl(
		com.rivetlogic.event.model.Target target)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the target with the primary key or throws a {@link com.rivetlogic.event.NoSuchTargetException} if it could not be found.
	*
	* @param targetId the primary key of the target
	* @return the target
	* @throws com.rivetlogic.event.NoSuchTargetException if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target findByPrimaryKey(long targetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTargetException;

	/**
	* Returns the target with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param targetId the primary key of the target
	* @return the target, or <code>null</code> if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Target fetchByPrimaryKey(long targetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the targets.
	*
	* @return the targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the targets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of targets
	* @param end the upper bound of the range of targets (not inclusive)
	* @return the range of targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the targets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of targets
	* @param end the upper bound of the range of targets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of targets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Target> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the targets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of targets.
	*
	* @return the number of targets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}