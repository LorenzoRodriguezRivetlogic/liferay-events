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
 * This class is a wrapper for {@link Target}.
 * </p>
 *
 * @author juancarrillo
 * @see Target
 * @generated
 */
public class TargetWrapper implements Target, ModelWrapper<Target> {
	public TargetWrapper(Target target) {
		_target = target;
	}

	@Override
	public Class<?> getModelClass() {
		return Target.class;
	}

	@Override
	public String getModelClassName() {
		return Target.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("targetId", getTargetId());
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
		Long targetId = (Long)attributes.get("targetId");

		if (targetId != null) {
			setTargetId(targetId);
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
	* Returns the primary key of this target.
	*
	* @return the primary key of this target
	*/
	@Override
	public long getPrimaryKey() {
		return _target.getPrimaryKey();
	}

	/**
	* Sets the primary key of this target.
	*
	* @param primaryKey the primary key of this target
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_target.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the target ID of this target.
	*
	* @return the target ID of this target
	*/
	@Override
	public long getTargetId() {
		return _target.getTargetId();
	}

	/**
	* Sets the target ID of this target.
	*
	* @param targetId the target ID of this target
	*/
	@Override
	public void setTargetId(long targetId) {
		_target.setTargetId(targetId);
	}

	/**
	* Returns the name of this target.
	*
	* @return the name of this target
	*/
	@Override
	public java.lang.String getName() {
		return _target.getName();
	}

	/**
	* Sets the name of this target.
	*
	* @param name the name of this target
	*/
	@Override
	public void setName(java.lang.String name) {
		_target.setName(name);
	}

	/**
	* Returns the description of this target.
	*
	* @return the description of this target
	*/
	@Override
	public java.lang.String getDescription() {
		return _target.getDescription();
	}

	/**
	* Sets the description of this target.
	*
	* @param description the description of this target
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_target.setDescription(description);
	}

	/**
	* Returns the group ID of this target.
	*
	* @return the group ID of this target
	*/
	@Override
	public long getGroupId() {
		return _target.getGroupId();
	}

	/**
	* Sets the group ID of this target.
	*
	* @param groupId the group ID of this target
	*/
	@Override
	public void setGroupId(long groupId) {
		_target.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this target.
	*
	* @return the company ID of this target
	*/
	@Override
	public long getCompanyId() {
		return _target.getCompanyId();
	}

	/**
	* Sets the company ID of this target.
	*
	* @param companyId the company ID of this target
	*/
	@Override
	public void setCompanyId(long companyId) {
		_target.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this target.
	*
	* @return the user ID of this target
	*/
	@Override
	public long getUserId() {
		return _target.getUserId();
	}

	/**
	* Sets the user ID of this target.
	*
	* @param userId the user ID of this target
	*/
	@Override
	public void setUserId(long userId) {
		_target.setUserId(userId);
	}

	/**
	* Returns the user uuid of this target.
	*
	* @return the user uuid of this target
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _target.getUserUuid();
	}

	/**
	* Sets the user uuid of this target.
	*
	* @param userUuid the user uuid of this target
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_target.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this target.
	*
	* @return the create date of this target
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _target.getCreateDate();
	}

	/**
	* Sets the create date of this target.
	*
	* @param createDate the create date of this target
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_target.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this target.
	*
	* @return the modified date of this target
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _target.getModifiedDate();
	}

	/**
	* Sets the modified date of this target.
	*
	* @param modifiedDate the modified date of this target
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_target.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _target.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_target.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _target.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_target.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _target.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _target.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_target.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _target.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_target.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_target.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_target.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TargetWrapper((Target)_target.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.event.model.Target target) {
		return _target.compareTo(target);
	}

	@Override
	public int hashCode() {
		return _target.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.event.model.Target> toCacheModel() {
		return _target.toCacheModel();
	}

	@Override
	public com.rivetlogic.event.model.Target toEscapedModel() {
		return new TargetWrapper(_target.toEscapedModel());
	}

	@Override
	public com.rivetlogic.event.model.Target toUnescapedModel() {
		return new TargetWrapper(_target.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _target.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _target.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_target.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TargetWrapper)) {
			return false;
		}

		TargetWrapper targetWrapper = (TargetWrapper)obj;

		if (Validator.equals(_target, targetWrapper._target)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Target getWrappedTarget() {
		return _target;
	}

	@Override
	public Target getWrappedModel() {
		return _target;
	}

	@Override
	public void resetOriginalValues() {
		_target.resetOriginalValues();
	}

	private Target _target;
}