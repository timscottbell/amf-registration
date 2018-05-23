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
 * Provides a wrapper for {@link AMFEventService}.
 *
 * @author Timothy Bell
 * @see AMFEventService
 * @generated
 */
@ProviderType
public class AMFEventServiceWrapper implements AMFEventService,
	ServiceWrapper<AMFEventService> {
	public AMFEventServiceWrapper(AMFEventService amfEventService) {
		_amfEventService = amfEventService;
	}

	@Override
	public int getAMFEventsCount(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type) throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventService.getAMFEventsCount(serviceContext, type);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfEventService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.amf.model.AMFEvent> getAMFEvents(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventService.getAMFEvents(serviceContext, type, start, end);
	}

	@Override
	public AMFEventService getWrappedService() {
		return _amfEventService;
	}

	@Override
	public void setWrappedService(AMFEventService amfEventService) {
		_amfEventService = amfEventService;
	}

	private AMFEventService _amfEventService;
}