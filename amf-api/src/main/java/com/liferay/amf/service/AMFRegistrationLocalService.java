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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Provides the local service interface for AMFRegistration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Timothy Bell
 * @see AMFRegistrationLocalServiceUtil
 * @see com.liferay.amf.service.base.AMFRegistrationLocalServiceBaseImpl
 * @see com.liferay.amf.service.impl.AMFRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AMFRegistrationLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFRegistrationLocalServiceUtil} to access the amf registration local service. Add custom service methods to {@link com.liferay.amf.service.impl.AMFRegistrationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public User registerUser(long creatorUserId, long companyId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, Locale locale,
		java.lang.String username, boolean male, int birthdayMonth,
		int birthdayDay, int birthdayYear, java.lang.String password1,
		java.lang.String password2, java.lang.String homePhone,
		java.lang.String mobilePhone, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String zip,
		java.lang.String securityQuestion, java.lang.String securityAnswer,
		boolean acceptedTOU, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRegisteredUsersCount(int zip);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getRegisteredUsers(int zip, int start, int end);
}