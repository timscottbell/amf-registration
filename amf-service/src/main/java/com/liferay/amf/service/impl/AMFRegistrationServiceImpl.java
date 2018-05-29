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

import com.liferay.amf.internal.permission.UserPermission;
import com.liferay.amf.service.base.AMFRegistrationServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Timothy Bell
 */
public class AMFRegistrationServiceImpl extends AMFRegistrationServiceBaseImpl {

	@Override
	public List<User> getRegisteredUsers(
			int zip, long groupId, int start, int end)
		throws PortalException {

		UserPermission.checkTopLevel(
			getPermissionChecker(), groupId, _VIEW_USERS);

		return amfRegistrationLocalService.getRegisteredUsers(zip, start, end);
	}

	@Override
	public int getRegisteredUsersCount(int zip, long groupId)
		throws PortalException {

		UserPermission.checkTopLevel(
			getPermissionChecker(), groupId, _VIEW_USERS);

		return amfRegistrationLocalService.getRegisteredUsersCount(zip);
	}

	private static final String _VIEW_USERS = "_VIEW_USERS";

}