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
 * Provides a wrapper for {@link AMFRegistrationLocalService}.
 *
 * @author Timothy Bell
 * @see AMFRegistrationLocalService
 * @generated
 */
@ProviderType
public class AMFRegistrationLocalServiceWrapper
	implements AMFRegistrationLocalService,
		ServiceWrapper<AMFRegistrationLocalService> {
	public AMFRegistrationLocalServiceWrapper(
		AMFRegistrationLocalService amfRegistrationLocalService) {
		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User registerUser(
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
		return _amfRegistrationLocalService.registerUser(creatorUserId,
			companyId, firstName, lastName, emailAddress, locale, username,
			male, birthdayMonth, birthdayDay, birthdayYear, password1,
			password2, homePhone, mobilePhone, address1, address2, city, state,
			zip, securityQuestion, securityAnswer, acceptedTOU, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public AMFRegistrationLocalService getWrappedService() {
		return _amfRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		AMFRegistrationLocalService amfRegistrationLocalService) {
		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	private AMFRegistrationLocalService _amfRegistrationLocalService;
}