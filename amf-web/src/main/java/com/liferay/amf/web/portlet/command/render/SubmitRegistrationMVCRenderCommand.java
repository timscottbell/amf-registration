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

package com.liferay.amf.web.portlet.command.render;

import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Timothy Bell
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_REGISTRATION,
		"mvc.command.name=/submit_registration"
	}
)
public class SubmitRegistrationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		String firstName = ParamUtil.getString(renderRequest, "first_name");

		renderRequest.setAttribute("first_name", firstName);

		String lastName = ParamUtil.getString(renderRequest, "last_name");

		renderRequest.setAttribute("last_name", lastName);

		String emailAddress = ParamUtil.getString(
			renderRequest, "email_address");

		renderRequest.setAttribute("email_address", emailAddress);

		String username = ParamUtil.getString(renderRequest, "username");

		renderRequest.setAttribute("username", username);

		boolean male = ParamUtil.getBoolean(renderRequest, "male");

		renderRequest.setAttribute("male", male);

		int birthdayMonth = ParamUtil.getInteger(renderRequest, "b_month");

		renderRequest.setAttribute("b_month", birthdayMonth);

		int birthdayDay = ParamUtil.getInteger(renderRequest, "b_day", 1);

		renderRequest.setAttribute("b_day", birthdayDay);

		int birthdayYear = ParamUtil.getInteger(renderRequest, "b_year", 1990);

		renderRequest.setAttribute("b_year", birthdayYear);

		String password1 = ParamUtil.getString(renderRequest, "password1");

		renderRequest.setAttribute("password1", password1);

		String password2 = ParamUtil.getString(renderRequest, "password2");

		renderRequest.setAttribute("password2", password2);

		String homePhone = ParamUtil.getString(renderRequest, "home_phone");

		renderRequest.setAttribute("home_phone", homePhone);

		String mobilePhone = ParamUtil.getString(renderRequest, "mobile_phone");

		renderRequest.setAttribute("mobile_phone", mobilePhone);

		String address1 = ParamUtil.getString(renderRequest, "address1");

		renderRequest.setAttribute("address1", address1);

		String address2 = ParamUtil.getString(renderRequest, "address2");

		renderRequest.setAttribute("address2", address2);

		String city = ParamUtil.getString(renderRequest, "city");

		renderRequest.setAttribute("city", city);

		String state = ParamUtil.getString(renderRequest, "state");

		renderRequest.setAttribute("state", state);

		String zip = ParamUtil.getString(renderRequest, "zip");

		renderRequest.setAttribute("zip", zip);

		String securityQuestion = ParamUtil.getString(
			renderRequest, "security_question");

		renderRequest.setAttribute("securityQuestion", securityQuestion);

		String securityAnswer = ParamUtil.getString(
			renderRequest, "security_answer");

		renderRequest.setAttribute("securityAnswer", securityAnswer);

		boolean acceptedTOU = ParamUtil.getBoolean(
			renderRequest, "accepted_tou");

		renderRequest.setAttribute("acceptedTOU", acceptedTOU);

		return "/registration/view.jsp";
	}

}