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

import com.liferay.amf.constants.AMFActionKeys;
import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.amf.internal.permission.AMFPermission;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.base.AMFEventServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * @author Timothy Bell
 */
public class AMFEventServiceImpl extends AMFEventServiceBaseImpl {

	@Override
	public List<AMFEvent> getAMFEvents(
			ServiceContext serviceContext, int type, int start, int end)
		throws PortalException {

		if (AMFPermission.containsPortletPermission(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				AMFPortletKeys.AMF_EVENT_MONITOR,
				AMFActionKeys.VIEW_EVENTS_OTHERS)) {

			return amfEventLocalService.getAMFEvents(type, start, end);
		}

		return amfEventLocalService.getAMFEvents(
			serviceContext.getUserId(), type, start, end);
	}

	@Override
	public int getAMFEventsCount(ServiceContext serviceContext, int type)
		throws PortalException {

		if (AMFPermission.containsPortletPermission(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				AMFPortletKeys.AMF_EVENT_MONITOR,
				AMFActionKeys.VIEW_EVENTS_OTHERS)) {

			return amfEventLocalService.getAMFEventsCount(type);
		}

		return amfEventLocalService.getAMFEventsCount(
			serviceContext.getUserId(), type);
	}

}