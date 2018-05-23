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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AMFEvent. This utility wraps
 * {@link com.liferay.amf.service.impl.AMFEventServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Timothy Bell
 * @see AMFEventService
 * @see com.liferay.amf.service.base.AMFEventServiceBaseImpl
 * @see com.liferay.amf.service.impl.AMFEventServiceImpl
 * @generated
 */
@ProviderType
public class AMFEventServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.amf.service.impl.AMFEventServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static int getAMFEventsCount(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFEventsCount(serviceContext, type);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.amf.model.AMFEvent> getAMFEvents(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFEvents(serviceContext, type, start, end);
	}

	public static AMFEventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFEventService, AMFEventService> _serviceTracker =
		ServiceTrackerFactory.open(AMFEventService.class);
}