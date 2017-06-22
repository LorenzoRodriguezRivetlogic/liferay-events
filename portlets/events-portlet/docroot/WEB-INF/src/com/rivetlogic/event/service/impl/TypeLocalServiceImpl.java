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
import com.rivetlogic.event.model.Type;
import com.rivetlogic.event.service.TypeLocalServiceUtil;
import com.rivetlogic.event.service.base.TypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.event.service.TypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author lorenzorodriguez
 * @see com.rivetlogic.event.service.base.TypeLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.TypeLocalServiceUtil
 */
public class TypeLocalServiceImpl extends TypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.event.service.TypeLocalServiceUtil} to access the type local service.
	 */
	public Type addType(long userId, long groupId, String name, String description, ServiceContext serviceContext) throws PortalException, SystemException {
	    User user = userPersistence.findByPrimaryKey(userId);

	    Date now = new Date();

	    long typeId = counterLocalService.increment(Type.class.getName());

	    Type type = typePersistence.create(typeId);
	    type.setName(name);
	    type.setDescription(description);

	    type.setUserId(user.getUserId());
	    type.setGroupId(groupId);
	    type.setCompanyId(user.getCompanyId());
	    type.setCreateDate(serviceContext.getCreateDate(now));
	    type.setModifiedDate(serviceContext.getModifiedDate(now));

	    super.addType(type);

	    return type;
	}
	
	public Type deleteType(Type type) throws SystemException {

	    return typePersistence.remove(type);
	}

	public Type deleteType(long typeId) throws PortalException, SystemException {

		Type type = typePersistence.findByPrimaryKey(typeId);

	    return deleteType(type);
	}

	public Type getType(long typeId) throws SystemException, PortalException {

	    return typePersistence.findByPrimaryKey(typeId);
	}

	public List<Type> getTypesByGroupId(long groupId) throws SystemException {

	    return typePersistence.findByGroupId(groupId);
	}

	public List<Type> getTypesByGroupId(long groupId, int start, int end) throws SystemException {

	    return typePersistence.findByGroupId(groupId, start, end);
	}

	public int getTypesCountByGroupId(long groupId) throws SystemException {

	    return typePersistence.countByGroupId(groupId);
	}

	public Type updateType(long userId, long typeId, String name, String description, ServiceContext serviceContext) throws PortalException, SystemException {

		Date now = new Date();

		Type type = TypeLocalServiceUtil.fetchType(typeId);

		type.setModifiedDate(serviceContext.getModifiedDate(now));
		type.setName(name);
		type.setDescription(description);

	    super.updateType(type);

	    return type;
	}   
	
	public Type deleteType(long typeId, ServiceContext serviceContext) throws PortalException, SystemException {

		Type type = getType(typeId);

		type = deleteType(type);

        return type;
	}
}