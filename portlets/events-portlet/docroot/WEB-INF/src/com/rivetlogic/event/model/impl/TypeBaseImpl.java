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

package com.rivetlogic.event.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.rivetlogic.event.model.Type;
import com.rivetlogic.event.service.TypeLocalServiceUtil;

/**
 * The extended model base implementation for the Type service. Represents a row in the &quot;rivetlogic_event_Type&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TypeImpl}.
 * </p>
 *
 * @author juancarrillo
 * @see TypeImpl
 * @see com.rivetlogic.event.model.Type
 * @generated
 */
public abstract class TypeBaseImpl extends TypeModelImpl implements Type {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a type model instance should use the {@link Type} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TypeLocalServiceUtil.addType(this);
		}
		else {
			TypeLocalServiceUtil.updateType(this);
		}
	}
}