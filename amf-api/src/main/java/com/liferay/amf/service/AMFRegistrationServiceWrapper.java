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

package com.liferay.amf.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFRegistrationService}.
 *
 * @author Timothy Bell
 * @see AMFRegistrationService
 * @generated
 */
@ProviderType
public class AMFRegistrationServiceWrapper implements AMFRegistrationService,
	ServiceWrapper<AMFRegistrationService> {
	public AMFRegistrationServiceWrapper(
		AMFRegistrationService amfRegistrationService) {
		_amfRegistrationService = amfRegistrationService;
	}

	@Override
	public int getRegisteredUsersCount(int zip, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationService.getRegisteredUsersCount(zip, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfRegistrationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getRegisteredUsers(
		int zip, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationService.getRegisteredUsers(zip, groupId, start,
			end);
	}

	@Override
	public AMFRegistrationService getWrappedService() {
		return _amfRegistrationService;
	}

	@Override
	public void setWrappedService(AMFRegistrationService amfRegistrationService) {
		_amfRegistrationService = amfRegistrationService;
	}

	private AMFRegistrationService _amfRegistrationService;
}