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

package com.rivetlogic.event.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.rivetlogic.event.model.Target;
import com.rivetlogic.event.service.TargetLocalServiceUtil;
import com.rivetlogic.event.service.base.TargetLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the target local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.event.service.TargetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lorenzorodriguez
 * @see com.rivetlogic.event.service.base.TargetLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.TargetLocalServiceUtil
 */
public class TargetLocalServiceImpl extends TargetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.event.service.TargetLocalServiceUtil} to access the target local service.
	 */
	public Target addTarget(long userId, long groupId, String name, String description, ServiceContext serviceContext) throws PortalException, SystemException {
	    User user = userPersistence.findByPrimaryKey(userId);

	    Date now = new Date();

	    long targetId = counterLocalService.increment(Target.class.getName());

	    Target target = targetPersistence.create(targetId);

	    target.setName(name);
	    target.setDescription(description);

	    target.setUserId(user.getUserId());
	    target.setGroupId(groupId);
	    target.setCompanyId(user.getCompanyId());
	    target.setCreateDate(serviceContext.getCreateDate(now));
	    target.setModifiedDate(serviceContext.getModifiedDate(now));

	    super.addTarget(target);

	    return target;
	}
	
	public Target deleteTarget(Target target) throws SystemException {

	    return targetPersistence.remove(target);
	}

	public Target deleteTarget(long targetId) throws PortalException, SystemException {

		Target target = targetPersistence.findByPrimaryKey(targetId);

	    return deleteTarget(target);
	}

	public Target getTarget(long targetId) throws SystemException, PortalException {

	    return targetPersistence.findByPrimaryKey(targetId);
	}

	public List<Target> getTargetsByGroupId(long groupId) throws SystemException {

	    return targetPersistence.findByGroupId(groupId);
	}

	public List<Target> getTargetsByGroupId(long groupId, int start, int end) throws SystemException {

	    return targetPersistence.findByGroupId(groupId, start, end);
	}

	public int getTargetsCountByGroupId(long groupId) throws SystemException {

	    return targetPersistence.countByGroupId(groupId);
	}

	public Target updateTarget(long userId, long targetId, String name, String description, ServiceContext serviceContext) throws PortalException, SystemException {

		Date now = new Date();

		Target target = TargetLocalServiceUtil.fetchTarget(targetId);

		target.setModifiedDate(serviceContext.getModifiedDate(now));
		target.setName(name);
		target.setDescription(description);

	    super.updateTarget(target);

	    return target;
	}   
	
	public Target deleteTarget(long targetId, ServiceContext serviceContext) throws PortalException, SystemException {

		Target target = getTarget(targetId);

		target = deleteTarget(target);

        return target;
	}
}