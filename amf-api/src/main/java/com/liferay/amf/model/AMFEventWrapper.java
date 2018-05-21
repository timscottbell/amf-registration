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

package com.liferay.amf.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AMFEvent}.
 * </p>
 *
 * @author Timothy Bell
 * @see AMFEvent
 * @generated
 */
@ProviderType
public class AMFEventWrapper implements AMFEvent, ModelWrapper<AMFEvent> {
	public AMFEventWrapper(AMFEvent amfEvent) {
		_amfEvent = amfEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return AMFEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AMFEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amfEventId", getAmfEventId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("type", getType());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long amfEventId = (Long)attributes.get("amfEventId");

		if (amfEventId != null) {
			setAmfEventId(amfEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long createTime = (Long)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public AMFEvent toEscapedModel() {
		return new AMFEventWrapper(_amfEvent.toEscapedModel());
	}

	@Override
	public AMFEvent toUnescapedModel() {
		return new AMFEventWrapper(_amfEvent.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _amfEvent.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _amfEvent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _amfEvent.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _amfEvent.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AMFEvent> toCacheModel() {
		return _amfEvent.toCacheModel();
	}

	@Override
	public int compareTo(AMFEvent amfEvent) {
		return _amfEvent.compareTo(amfEvent);
	}

	/**
	* Returns the type of this amf event.
	*
	* @return the type of this amf event
	*/
	@Override
	public int getType() {
		return _amfEvent.getType();
	}

	@Override
	public int hashCode() {
		return _amfEvent.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfEvent.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AMFEventWrapper((AMFEvent)_amfEvent.clone());
	}

	/**
	* Returns the ip address of this amf event.
	*
	* @return the ip address of this amf event
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _amfEvent.getIpAddress();
	}

	/**
	* Returns the user name of this amf event.
	*
	* @return the user name of this amf event
	*/
	@Override
	public java.lang.String getUserName() {
		return _amfEvent.getUserName();
	}

	/**
	* Returns the user uuid of this amf event.
	*
	* @return the user uuid of this amf event
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _amfEvent.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _amfEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _amfEvent.toXmlString();
	}

	/**
	* Returns the amf event ID of this amf event.
	*
	* @return the amf event ID of this amf event
	*/
	@Override
	public long getAmfEventId() {
		return _amfEvent.getAmfEventId();
	}

	/**
	* Returns the create time of this amf event.
	*
	* @return the create time of this amf event
	*/
	@Override
	public long getCreateTime() {
		return _amfEvent.getCreateTime();
	}

	/**
	* Returns the primary key of this amf event.
	*
	* @return the primary key of this amf event
	*/
	@Override
	public long getPrimaryKey() {
		return _amfEvent.getPrimaryKey();
	}

	/**
	* Returns the user ID of this amf event.
	*
	* @return the user ID of this amf event
	*/
	@Override
	public long getUserId() {
		return _amfEvent.getUserId();
	}

	@Override
	public void persist() {
		_amfEvent.persist();
	}

	/**
	* Sets the amf event ID of this amf event.
	*
	* @param amfEventId the amf event ID of this amf event
	*/
	@Override
	public void setAmfEventId(long amfEventId) {
		_amfEvent.setAmfEventId(amfEventId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_amfEvent.setCachedModel(cachedModel);
	}

	/**
	* Sets the create time of this amf event.
	*
	* @param createTime the create time of this amf event
	*/
	@Override
	public void setCreateTime(long createTime) {
		_amfEvent.setCreateTime(createTime);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_amfEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_amfEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_amfEvent.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ip address of this amf event.
	*
	* @param ipAddress the ip address of this amf event
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_amfEvent.setIpAddress(ipAddress);
	}

	@Override
	public void setNew(boolean n) {
		_amfEvent.setNew(n);
	}

	/**
	* Sets the primary key of this amf event.
	*
	* @param primaryKey the primary key of this amf event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_amfEvent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_amfEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this amf event.
	*
	* @param type the type of this amf event
	*/
	@Override
	public void setType(int type) {
		_amfEvent.setType(type);
	}

	/**
	* Sets the user ID of this amf event.
	*
	* @param userId the user ID of this amf event
	*/
	@Override
	public void setUserId(long userId) {
		_amfEvent.setUserId(userId);
	}

	/**
	* Sets the user name of this amf event.
	*
	* @param userName the user name of this amf event
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_amfEvent.setUserName(userName);
	}

	/**
	* Sets the user uuid of this amf event.
	*
	* @param userUuid the user uuid of this amf event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_amfEvent.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFEventWrapper)) {
			return false;
		}

		AMFEventWrapper amfEventWrapper = (AMFEventWrapper)obj;

		if (Objects.equals(_amfEvent, amfEventWrapper._amfEvent)) {
			return true;
		}

		return false;
	}

	@Override
	public AMFEvent getWrappedModel() {
		return _amfEvent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _amfEvent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _amfEvent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_amfEvent.resetOriginalValues();
	}

	private final AMFEvent _amfEvent;
}