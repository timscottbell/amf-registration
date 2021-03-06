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

package com.liferay.amf.service.impl;

import com.liferay.amf.constants.AMFEventConstants;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.base.AMFEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Timothy Bell
 */
public class AMFEventLocalServiceImpl extends AMFEventLocalServiceBaseImpl {

	@Override
	public AMFEvent addAMFEvent(long userId, int type, String ipAddress)
		throws PortalException {

		long assetEntrySetId = counterLocalService.increment();

		AMFEvent amfEvent = amfEventPersistence.create(assetEntrySetId);

		amfEvent.setUserId(userId);

		User user = userLocalService.getUserById(userId);

		amfEvent.setUserName(user.getScreenName());

		amfEvent.setCreateTime(System.currentTimeMillis());
		amfEvent.setType(type);
		amfEvent.setIpAddress(ipAddress);

		amfEventPersistence.update(amfEvent);

		return amfEvent;
	}

	@Override
	public List<AMFEvent> getAMFEvents(int type, int start, int end) {
		if (type == AMFEventConstants.TYPE_ANY) {
			return amfEventPersistence.findAll(start, end);
		}

		return amfEventPersistence.findByType(type, start, end);
	}

	@Override
	public List<AMFEvent> getAMFEvents(
		long userId, int type, int start, int end) {

		if (type == AMFEventConstants.TYPE_ANY) {
			return amfEventPersistence.findByUserId(userId, start, end);
		}

		return amfEventPersistence.findByU_T(userId, type, start, end);
	}

	@Override
	public int getAMFEventsCount(int type) {
		if (type == AMFEventConstants.TYPE_ANY) {
			return amfEventPersistence.countAll();
		}

		return amfEventPersistence.countByType(type);
	}

	@Override
	public int getAMFEventsCount(long userId, int type) {
		if (type == AMFEventConstants.TYPE_ANY) {
			return amfEventPersistence.countByUserId(userId);
		}

		return amfEventPersistence.countByU_T(userId, type);
	}

}