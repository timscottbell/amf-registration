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
 * Provides the local service utility for AMFRegistration. This utility wraps
 * {@link com.liferay.amf.service.impl.AMFRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Timothy Bell
 * @see AMFRegistrationLocalService
 * @see com.liferay.amf.service.base.AMFRegistrationLocalServiceBaseImpl
 * @see com.liferay.amf.service.impl.AMFRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class AMFRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.amf.service.impl.AMFRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User registerUser(
		long creatorUserId, long companyId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.util.Locale locale, java.lang.String username, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear,
		java.lang.String password1, java.lang.String password2,
		java.lang.String homePhone, java.lang.String mobilePhone,
		java.lang.String address1, java.lang.String address2,
		java.lang.String city, java.lang.String state, java.lang.String zip,
		java.lang.String securityQuestion, java.lang.String securityAnswer,
		boolean acceptedTOU,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .registerUser(creatorUserId, companyId, firstName, lastName,
			emailAddress, locale, username, male, birthdayMonth, birthdayDay,
			birthdayYear, password1, password2, homePhone, mobilePhone,
			address1, address2, city, state, zip, securityQuestion,
			securityAnswer, acceptedTOU, serviceContext);
	}

	public static int getRegisteredUsersCount(int zip) {
		return getService().getRegisteredUsersCount(zip);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.User> getRegisteredUsers(
		int zip, int start, int end) {
		return getService().getRegisteredUsers(zip, start, end);
	}

	public static AMFRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFRegistrationLocalService, AMFRegistrationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AMFRegistrationLocalService.class);
}