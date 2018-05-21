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

package com.liferay.amf.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.model.AMFEvent;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AMFEvent in entity cache.
 *
 * @author Timothy Bell
 * @see AMFEvent
 * @generated
 */
@ProviderType
public class AMFEventCacheModel implements CacheModel<AMFEvent>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFEventCacheModel)) {
			return false;
		}

		AMFEventCacheModel amfEventCacheModel = (AMFEventCacheModel)obj;

		if (amfEventId == amfEventCacheModel.amfEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{amfEventId=");
		sb.append(amfEventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", type=");
		sb.append(type);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFEvent toEntityModel() {
		AMFEventImpl amfEventImpl = new AMFEventImpl();

		amfEventImpl.setAmfEventId(amfEventId);
		amfEventImpl.setUserId(userId);

		if (userName == null) {
			amfEventImpl.setUserName(StringPool.BLANK);
		}
		else {
			amfEventImpl.setUserName(userName);
		}

		amfEventImpl.setCreateTime(createTime);
		amfEventImpl.setType(type);

		if (ipAddress == null) {
			amfEventImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			amfEventImpl.setIpAddress(ipAddress);
		}

		amfEventImpl.resetOriginalValues();

		return amfEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amfEventId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		createTime = objectInput.readLong();

		type = objectInput.readInt();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(amfEventId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);

		objectOutput.writeInt(type);

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long amfEventId;
	public long userId;
	public String userName;
	public long createTime;
	public int type;
	public String ipAddress;
}