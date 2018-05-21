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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Timothy Bell
 * @generated
 */
@ProviderType
public class AMFEventSoap implements Serializable {
	public static AMFEventSoap toSoapModel(AMFEvent model) {
		AMFEventSoap soapModel = new AMFEventSoap();

		soapModel.setAmfEventId(model.getAmfEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setType(model.getType());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static AMFEventSoap[] toSoapModels(AMFEvent[] models) {
		AMFEventSoap[] soapModels = new AMFEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFEventSoap[][] toSoapModels(AMFEvent[][] models) {
		AMFEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFEventSoap[] toSoapModels(List<AMFEvent> models) {
		List<AMFEventSoap> soapModels = new ArrayList<AMFEventSoap>(models.size());

		for (AMFEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFEventSoap[soapModels.size()]);
	}

	public AMFEventSoap() {
	}

	public long getPrimaryKey() {
		return _amfEventId;
	}

	public void setPrimaryKey(long pk) {
		setAmfEventId(pk);
	}

	public long getAmfEventId() {
		return _amfEventId;
	}

	public void setAmfEventId(long amfEventId) {
		_amfEventId = amfEventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCreateTime() {
		return _createTime;
	}

	public void setCreateTime(long createTime) {
		_createTime = createTime;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _amfEventId;
	private long _userId;
	private String _userName;
	private long _createTime;
	private int _type;
	private String _ipAddress;
}