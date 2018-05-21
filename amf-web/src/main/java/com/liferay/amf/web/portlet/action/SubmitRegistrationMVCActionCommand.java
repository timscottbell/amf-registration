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

package com.liferay.amf.web.portlet.action;

import com.liferay.amf.AMFRegistrationService;
import com.liferay.amf.exception.AlphanumericException;
import com.liferay.amf.exception.MaxCharacterException;
import com.liferay.amf.exception.PhoneException;
import com.liferay.amf.exception.SecurityQuestionException;
import com.liferay.amf.exception.UserBirthdayException;
import com.liferay.amf.exception.UserPasswordException;
import com.liferay.amf.exception.UserUsernameException;
import com.liferay.amf.web.constants.AMFPortletKeys;
import com.liferay.portal.kernel.exception.AddressZipException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.RegionCodeException;
import com.liferay.portal.kernel.exception.TermsOfUseException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Timothy Bell
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_REGISTRATION,
		"mvc.command.name=/submit_registration"
	}
)
public class SubmitRegistrationMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();

		Company company = themeDisplay.getCompany();

		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String emailAddress = ParamUtil.getString(
			actionRequest, "email_address");

		Locale locale = themeDisplay.getLocale();

		String username = ParamUtil.getString(actionRequest, "username");
		boolean male = ParamUtil.getBoolean(actionRequest, "male");
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "b_month");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "b_day");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "b_year");
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");
		String homePhone = ParamUtil.getString(actionRequest, "home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String securityQuestion = ParamUtil.getString(
			actionRequest, "security_question");
		String securityAnswer = ParamUtil.getString(
			actionRequest, "security_answer");
		boolean acceptedTOU = ParamUtil.getBoolean(
			actionRequest, "accepted_tou");

		ServiceContext serviceContext = null;

		try {
			serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);

			_amfRegistrationService.registerUser(
				user.getUserId(), company.getCompanyId(), firstName, lastName,
				emailAddress, locale, username, male, birthdayMonth,
				birthdayDay, birthdayYear, password1, password2, homePhone,
				mobilePhone, address1, address2, city, state, zip,
				securityQuestion, securityAnswer, acceptedTOU, serviceContext);
		}
		catch (PortalException pe) {
			if (pe instanceof AddressZipException ||
				pe instanceof AlphanumericException ||
				pe instanceof MaxCharacterException ||
				pe instanceof PhoneException ||
				pe instanceof RegionCodeException ||
				pe instanceof SecurityQuestionException ||
				pe instanceof TermsOfUseException ||
				pe instanceof UserBirthdayException ||
				pe instanceof UserPasswordException ||
				pe instanceof UserUsernameException) {

				SessionErrors.add(actionRequest, pe.getClass(), pe);
			}
			else {
				throw new PortletException(pe);
			}
		}

		return true;
	}

	@Reference
	private AMFRegistrationService _amfRegistrationService;

}