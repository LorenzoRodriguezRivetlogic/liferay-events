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

package com.rivetlogic.event.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TargetLocalService}.
 *
 * @author juancarrillo
 * @see TargetLocalService
 * @generated
 */
public class TargetLocalServiceWrapper implements TargetLocalService,
	ServiceWrapper<TargetLocalService> {
	public TargetLocalServiceWrapper(TargetLocalService targetLocalService) {
		_targetLocalService = targetLocalService;
	}

	/**
	* Adds the target to the database. Also notifies the appropriate model listeners.
	*
	* @param target the target
	* @return the target that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Target addTarget(
		com.rivetlogic.event.model.Target target)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.addTarget(target);
	}

	/**
	* Creates a new target with the primary key. Does not add the target to the database.
	*
	* @param targetId the primary key for the new target
	* @return the new target
	*/
	@Override
	public com.rivetlogic.event.model.Target createTarget(long targetId) {
		return _targetLocalService.createTarget(targetId);
	}

	/**
	* Deletes the target with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param targetId the primary key of the target
	* @return the target that was removed
	* @throws PortalException if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Target deleteTarget(long targetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.deleteTarget(targetId);
	}

	/**
	* Deletes the target from the database. Also notifies the appropriate model listeners.
	*
	* @param target the target
	* @return the target that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Target deleteTarget(
		com.rivetlogic.event.model.Target target)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.deleteTarget(target);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _targetLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TargetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rivetlogic.event.model.Target fetchTarget(long targetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.fetchTarget(targetId);
	}

	/**
	* Returns the target with the primary key.
	*
	* @param targetId the primary key of the target
	* @return the target
	* @throws PortalException if a target with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Target getTarget(long targetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTarget(targetId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.rivetlogic.event.model.Target> getTargets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTargets(start, end);
	}

	/**
	* Returns the number of targets.
	*
	* @return the number of targets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTargetsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTargetsCount();
	}

	/**
	* Updates the target in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param target the target
	* @return the target that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Target updateTarget(
		com.rivetlogic.event.model.Target target)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.updateTarget(target);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _targetLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_targetLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _targetLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rivetlogic.event.model.Target addTarget(long userId,
		long groupId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.addTarget(userId, groupId, name,
			description, serviceContext);
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Target> getTargetsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTargetsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Target> getTargetsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTargetsByGroupId(groupId, start, end);
	}

	@Override
	public int getTargetsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.getTargetsCountByGroupId(groupId);
	}

	@Override
	public com.rivetlogic.event.model.Target updateTarget(long userId,
		long targetId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.updateTarget(userId, targetId, name,
			description, serviceContext);
	}

	@Override
	public com.rivetlogic.event.model.Target deleteTarget(long targetId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _targetLocalService.deleteTarget(targetId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TargetLocalService getWrappedTargetLocalService() {
		return _targetLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTargetLocalService(
		TargetLocalService targetLocalService) {
		_targetLocalService = targetLocalService;
	}

	@Override
	public TargetLocalService getWrappedService() {
		return _targetLocalService;
	}

	@Override
	public void setWrappedService(TargetLocalService targetLocalService) {
		_targetLocalService = targetLocalService;
	}

	private TargetLocalService _targetLocalService;
}