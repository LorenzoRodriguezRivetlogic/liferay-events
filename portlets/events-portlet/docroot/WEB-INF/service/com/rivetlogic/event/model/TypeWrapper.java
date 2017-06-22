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

package com.rivetlogic.event.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Type}.
 * </p>
 *
 * @author juancarrillo
 * @see Type
 * @generated
 */
public class TypeWrapper implements Type, ModelWrapper<Type> {
	public TypeWrapper(Type type) {
		_type = type;
	}

	@Override
	public Class<?> getModelClass() {
		return Type.class;
	}

	@Override
	public String getModelClassName() {
		return Type.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeId", getTypeId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this type.
	*
	* @return the primary key of this type
	*/
	@Override
	public long getPrimaryKey() {
		return _type.getPrimaryKey();
	}

	/**
	* Sets the primary key of this type.
	*
	* @param primaryKey the primary key of this type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_type.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this type.
	*
	* @return the type ID of this type
	*/
	@Override
	public long getTypeId() {
		return _type.getTypeId();
	}

	/**
	* Sets the type ID of this type.
	*
	* @param typeId the type ID of this type
	*/
	@Override
	public void setTypeId(long typeId) {
		_type.setTypeId(typeId);
	}

	/**
	* Returns the name of this type.
	*
	* @return the name of this type
	*/
	@Override
	public java.lang.String getName() {
		return _type.getName();
	}

	/**
	* Sets the name of this type.
	*
	* @param name the name of this type
	*/
	@Override
	public void setName(java.lang.String name) {
		_type.setName(name);
	}

	/**
	* Returns the description of this type.
	*
	* @return the description of this type
	*/
	@Override
	public java.lang.String getDescription() {
		return _type.getDescription();
	}

	/**
	* Sets the description of this type.
	*
	* @param description the description of this type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_type.setDescription(description);
	}

	/**
	* Returns the group ID of this type.
	*
	* @return the group ID of this type
	*/
	@Override
	public long getGroupId() {
		return _type.getGroupId();
	}

	/**
	* Sets the group ID of this type.
	*
	* @param groupId the group ID of this type
	*/
	@Override
	public void setGroupId(long groupId) {
		_type.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this type.
	*
	* @return the company ID of this type
	*/
	@Override
	public long getCompanyId() {
		return _type.getCompanyId();
	}

	/**
	* Sets the company ID of this type.
	*
	* @param companyId the company ID of this type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_type.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this type.
	*
	* @return the user ID of this type
	*/
	@Override
	public long getUserId() {
		return _type.getUserId();
	}

	/**
	* Sets the user ID of this type.
	*
	* @param userId the user ID of this type
	*/
	@Override
	public void setUserId(long userId) {
		_type.setUserId(userId);
	}

	/**
	* Returns the user uuid of this type.
	*
	* @return the user uuid of this type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _type.getUserUuid();
	}

	/**
	* Sets the user uuid of this type.
	*
	* @param userUuid the user uuid of this type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_type.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this type.
	*
	* @return the create date of this type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _type.getCreateDate();
	}

	/**
	* Sets the create date of this type.
	*
	* @param createDate the create date of this type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_type.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this type.
	*
	* @return the modified date of this type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _type.getModifiedDate();
	}

	/**
	* Sets the modified date of this type.
	*
	* @param modifiedDate the modified date of this type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_type.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _type.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_type.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _type.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_type.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _type.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _type.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_type.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _type.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_type.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_type.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_type.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TypeWrapper((Type)_type.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.event.model.Type type) {
		return _type.compareTo(type);
	}

	@Override
	public int hashCode() {
		return _type.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.event.model.Type> toCacheModel() {
		return _type.toCacheModel();
	}

	@Override
	public com.rivetlogic.event.model.Type toEscapedModel() {
		return new TypeWrapper(_type.toEscapedModel());
	}

	@Override
	public com.rivetlogic.event.model.Type toUnescapedModel() {
		return new TypeWrapper(_type.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _type.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _type.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_type.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeWrapper)) {
			return false;
		}

		TypeWrapper typeWrapper = (TypeWrapper)obj;

		if (Validator.equals(_type, typeWrapper._type)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Type getWrappedType() {
		return _type;
	}

	@Override
	public Type getWrappedModel() {
		return _type;
	}

	@Override
	public void resetOriginalValues() {
		_type.resetOriginalValues();
	}

	private Type _type;
}