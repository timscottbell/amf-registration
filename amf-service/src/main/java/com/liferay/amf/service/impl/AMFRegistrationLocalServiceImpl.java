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

import com.liferay.amf.constants.AMFRegistrationConstants;
import com.liferay.amf.exception.AlphanumericException;
import com.liferay.amf.exception.MaxCharacterException;
import com.liferay.amf.exception.PhoneException;
import com.liferay.amf.exception.RequiredFieldException;
import com.liferay.amf.exception.SecurityQuestionException;
import com.liferay.amf.exception.UserBirthdayException;
import com.liferay.amf.exception.UserEmailAddressException;
import com.liferay.amf.exception.UserPasswordException;
import com.liferay.amf.exception.UserUsernameException;
import com.liferay.amf.service.base.AMFRegistrationLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.AddressZipException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.RegionCodeException;
import com.liferay.portal.kernel.exception.TermsOfUseException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
@author Timothy Bell
 */
public class AMFRegistrationLocalServiceImpl
	extends AMFRegistrationLocalServiceBaseImpl {

	@Override
	public List<User> getRegisteredUsers(int zip, int start, int end) {
		return userLocalService.dynamicQuery(getDynamicQuery(zip), start, end);
	}

	@Override
	public int getRegisteredUsersCount(int zip) {
		return (int)userLocalService.dynamicQueryCount(getDynamicQuery(zip));
	}

	@Override
	public User registerUser(
			long creatorUserId, long companyId, String firstName,
			String lastName, String emailAddress, Locale locale,
			String username, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, String password1, String password2,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zip,
			String securityQuestion, String securityAnswer, boolean acceptedTOU,
			ServiceContext serviceContext)
		throws PortalException {

		validate(
			companyId, firstName, lastName, emailAddress, username,
			birthdayMonth, birthdayDay, birthdayYear, password1, password2,
			homePhone, mobilePhone, address1, address2, city, state, zip,
			securityQuestion, securityAnswer, acceptedTOU);

		User user = userLocalService.addUserWithWorkflow(
			creatorUserId, companyId, false, password1, password2, false,
			username, emailAddress, 0, StringPool.BLANK, locale, firstName,
			StringPool.BLANK, lastName, 0, 0, male, birthdayMonth, birthdayDay,
			birthdayYear, StringPool.BLANK, null, null, null, null, false,
			serviceContext);

		Contact contact = user.getContact();

		Country country = countryService.getCountryByName("united-states");

		Region region = regionService.getRegion(country.getCountryId(), state);

		List<ListType> addressListTypes = listTypeLocalService.getListTypes(
			ListTypeConstants.CONTACT_ADDRESS);

		ListType addressListType = addressListTypes.get(0);

		addressLocalService.addAddress(
			user.getUserId(), Contact.class.getName(), contact.getPrimaryKey(),
			address1, address2, StringPool.BLANK, city, zip,
			region.getRegionId(), country.getCountryId(),
			addressListType.getListTypeId(), true, true, serviceContext);

		List<ListType> phoneListTypes = listTypeLocalService.getListTypes(
			ListTypeConstants.CONTACT_PHONE);

		for (ListType phoneListType : phoneListTypes) {
			if (StringUtil.equalsIgnoreCase(
					phoneListType.getName(), "personal") &&
				Validator.isNotNull(homePhone)) {

				phoneLocalService.addPhone(
					creatorUserId, Contact.class.getName(), user.getContactId(),
					homePhone, StringPool.BLANK, phoneListType.getListTypeId(),
					false, serviceContext);
			}
			else if (StringUtil.equalsIgnoreCase(
						phoneListType.getName(), "mobile-phone") &&
					 Validator.isNotNull(mobilePhone)) {

				phoneLocalService.addPhone(
					creatorUserId, Contact.class.getName(), user.getContactId(),
					mobilePhone, StringPool.BLANK,
					phoneListType.getListTypeId(), false, serviceContext);
			}
		}

		userLocalService.updateReminderQuery(
			user.getUserId(), securityQuestion, securityAnswer);

		userLocalService.updateAgreedToTermsOfUse(
			user.getUserId(), acceptedTOU);

		return user;
	}

	protected DynamicQuery getDynamicQuery(int zip) {
		DynamicQuery addressDynamicQuery = DynamicQueryFactoryUtil.forClass(
			Address.class);

		Projection userIdProjection = ProjectionFactoryUtil.property("userId");

		addressDynamicQuery.setProjection(
			ProjectionFactoryUtil.distinct(userIdProjection));

		addressDynamicQuery.add(
			RestrictionsFactoryUtil.eq("zip", String.valueOf(zip)));

		addressDynamicQuery.add(RestrictionsFactoryUtil.eq("primary", true));

		DynamicQuery userDynamicQuery = DynamicQueryFactoryUtil.forClass(
			User.class);

		Property userIdProperty = PropertyFactoryUtil.forName("userId");

		userDynamicQuery.add(userIdProperty.in(addressDynamicQuery));

		return userDynamicQuery;
	}

	protected void validate(
			long companyId, String firstName, String lastName,
			String emailAddress, String username, int birthdayMonth,
			int birthdayDay, int birthdayYear, String password1,
			String password2, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			String zip, String securityQuestion, String securityAnswer,
			boolean acceptedTOU)
		throws PortalException {

		validateFirstName(firstName);

		validateLastName(lastName);

		validateEmailAddress(emailAddress);

		validateUsername(companyId, username);

		validateBirthday(birthdayMonth, birthdayDay, birthdayYear);

		validatePassword(password1, password2);

		validatePhone(homePhone, "home-phone");

		validatePhone(mobilePhone, "mobile-phone");

		validateAddress(address1, address2, city, state, zip);

		validateMisc(securityQuestion, securityAnswer, acceptedTOU);
	}

	protected void validateAddress(
			String address1, String address2, String city, String state,
			String zip)
		throws PortalException {

		validateRequiredField(address1);

		validateAlphanumeric(address1, _LANGUAGE_KEY_ADDRESS_1);

		validateMaxCharacters(address1, 255, _LANGUAGE_KEY_ADDRESS_1);

		if (Validator.isNotNull(address2)) {
			validateAlphanumeric(address2, _LANGUAGE_KEY_ADDRESS_2);

			validateMaxCharacters(address2, 255, _LANGUAGE_KEY_ADDRESS_2);
		}

		validateRequiredField(city);

		validateAlphanumeric(city, _LANGUAGE_KEY_CITY);

		validateMaxCharacters(city, 255, _LANGUAGE_KEY_CITY);

		Country country = countryService.getCountryByName("united-states");

		Region region = regionService.fetchRegion(
			country.getCountryId(), state);

		if (region == null) {
			throw new RegionCodeException();
		}

		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new AddressZipException();
		}
	}

	protected void validateAlphanumeric(String word, String fieldName)
		throws AlphanumericException {

		if (!Validator.isAlphanumericName(word)) {
			throw new AlphanumericException(fieldName);
		}
	}

	protected void validateBirthday(
			int birthdayMonth, int birthdayDay, int birthdayYear)
		throws UserBirthdayException {

		Calendar now = CalendarFactoryUtil.getCalendar(
			System.currentTimeMillis());

		Calendar birthday = CalendarFactoryUtil.getCalendar(
			birthdayYear, birthdayMonth, birthdayDay);

		int diff = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

		if ((birthday.get(Calendar.MONTH) > now.get(Calendar.MONTH)) ||
			((birthday.get(Calendar.MONTH) == now.get(Calendar.MONTH)) &&
			 (birthday.get(Calendar.DATE) > now.get(Calendar.DATE)))) {

			diff--;
		}

		if (diff < _USER_MINIMUM_AGE_REQUIREMENT) {
			throw new UserBirthdayException(_USER_MINIMUM_AGE_REQUIREMENT);
		}
	}

	protected void validateEmailAddress(String emailAddress)
		throws PortalException {

		validateRequiredField(emailAddress);

		validateMaxCharacters(emailAddress, 255, _LANGUAGE_KEY_EMAIL_ADDRESS);

		Pattern pattern = Pattern.compile(_REGEX_EMAIL_ADDRESS);

		Matcher matcher = pattern.matcher(emailAddress);

		if (!matcher.matches()) {
			throw new UserEmailAddressException();
		}
	}

	protected void validateFirstName(String firstName) throws PortalException {
		validateRequiredField(firstName);

		validateAlphanumeric(firstName, _LANGUAGE_KEY_FIRST_NAME);

		validateMaxCharacters(firstName, 50, _LANGUAGE_KEY_FIRST_NAME);
	}

	protected void validateLastName(String lastName) throws PortalException {
		validateRequiredField(lastName);

		validateAlphanumeric(lastName, _LANGUAGE_KEY_LAST_NAME);

		validateMaxCharacters(lastName, 50, _LANGUAGE_KEY_LAST_NAME);
	}

	protected void validateMaxCharacters(
			String word, int maxLength, String fieldName)
		throws MaxCharacterException {

		if (word.length() > maxLength) {
			throw new MaxCharacterException(fieldName, maxLength);
		}
	}

	protected void validateMisc(
			String securityQuestion, String securityAnswer, boolean acceptedTOU)
		throws PortalException {

		if (!ArrayUtil.contains(
				AMFRegistrationConstants.SECURITY_QUESTIONS,
				securityQuestion)) {

			throw new SecurityQuestionException();
		}

		validateRequiredField(securityAnswer);

		validateAlphanumeric(securityAnswer, _LANGUAGE_KEY_SECURITY_ANSWER);

		validateMaxCharacters(
			securityAnswer, 255, _LANGUAGE_KEY_SECURITY_ANSWER);

		if (!acceptedTOU) {
			throw new TermsOfUseException();
		}
	}

	protected void validatePassword(String password1, String password2)
		throws PortalException {

		validateRequiredField(password1);

		if (password1.length() < _USER_PASSWORD_LENGTH) {
			throw new UserPasswordException.MustBeLonger(_USER_PASSWORD_LENGTH);
		}

		if (!password1.equals(password2)) {
			throw new UserPasswordException.MustMatch();
		}

		Pattern pattern = Pattern.compile(_REGEX_PASSWORD);

		Matcher matcher = pattern.matcher(password1);

		if (!matcher.matches()) {
			throw new UserPasswordException.MustComplyWithRegex();
		}
	}

	protected void validatePhone(String phone, String type)
		throws PhoneException {

		if (Validator.isNotNull(phone) &&
			(!Validator.isDigit(phone) || (phone.length() != 10))) {

			throw new PhoneException(type);
		}
	}

	protected void validateRequiredField(String field)
		throws RequiredFieldException {

		if (Validator.isNull(field)) {
			throw new RequiredFieldException();
		}
	}

	protected void validateUsername(long companyId, String username)
		throws PortalException {

		validateRequiredField(username);

		validateAlphanumeric(username, "username");

		if ((username.length() < _USER_USERNAME_MIN_LENGTH) ||
			(username.length() > _USER_USERNAME_MAX_LENGTH)) {

			throw new UserUsernameException.MustBeCertainLength(
				_USER_USERNAME_MIN_LENGTH, _USER_USERNAME_MAX_LENGTH);
		}

		User user = userLocalService.fetchUserByScreenName(companyId, username);

		if (user != null) {
			throw new UserUsernameException.MustBeUnique();
		}
	}

	@ServiceReference(type = CountryService.class)
	protected CountryService countryService;

	@ServiceReference(type = RegionService.class)
	protected RegionService regionService;

	private static final String _LANGUAGE_KEY_ADDRESS_1 = "address-1";

	private static final String _LANGUAGE_KEY_ADDRESS_2 = "address-2";

	private static final String _LANGUAGE_KEY_CITY = "city";

	private static final String _LANGUAGE_KEY_EMAIL_ADDRESS = "email-address";

	private static final String _LANGUAGE_KEY_FIRST_NAME = "first-name";

	private static final String _LANGUAGE_KEY_LAST_NAME = "last-name";

	private static final String _LANGUAGE_KEY_SECURITY_ANSWER =
		"security-answer";

	private static final String _REGEX_EMAIL_ADDRESS = "^[\\w.@]+$";

	private static final String _REGEX_PASSWORD =
		"^(?=.*[A-Z])(?=.*\\d)(?=.*([-+_!@#$%^&*.,?])).+$";

	private static final int _USER_MINIMUM_AGE_REQUIREMENT = 13;

	private static final int _USER_PASSWORD_LENGTH = 6;

	private static final int _USER_USERNAME_MAX_LENGTH = 16;

	private static final int _USER_USERNAME_MIN_LENGTH = 4;

}