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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.event.model.Target;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Target in entity cache.
 *
 * @author juancarrillo
 * @see Target
 * @generated
 */
public class TargetCacheModel implements CacheModel<Target>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{targetId=");
		sb.append(targetId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Target toEntityModel() {
		TargetImpl targetImpl = new TargetImpl();

		targetImpl.setTargetId(targetId);

		if (name == null) {
			targetImpl.setName(StringPool.BLANK);
		}
		else {
			targetImpl.setName(name);
		}

		if (description == null) {
			targetImpl.setDescription(StringPool.BLANK);
		}
		else {
			targetImpl.setDescription(description);
		}

		targetImpl.setGroupId(groupId);
		targetImpl.setCompanyId(companyId);
		targetImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			targetImpl.setCreateDate(null);
		}
		else {
			targetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			targetImpl.setModifiedDate(null);
		}
		else {
			targetImpl.setModifiedDate(new Date(modifiedDate));
		}

		targetImpl.resetOriginalValues();

		return targetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		targetId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(targetId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long targetId;
	public String name;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}