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

package com.liferay.amf.web.display.context;

import com.liferay.amf.exception.AlphanumericException;
import com.liferay.amf.exception.MaxCharacterException;
import com.liferay.amf.exception.PhoneException;
import com.liferay.amf.exception.UserBirthdayException;
import com.liferay.amf.exception.UserPasswordException;
import com.liferay.amf.exception.UserUsernameException;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.AMFEventServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.text.DateFormat;

import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.jsp.PageContext;

/**
 * @author Timothy Bell
 */
public class AMFDisplayContext {

	public String getErrorMessageKey(Object object) {
		if (object instanceof AlphanumericException) {
			AlphanumericException ae = (AlphanumericException)object;

			return "the-field-" + ae.fieldName + "-must-be-alphanumeric";
		}
		else if (object instanceof MaxCharacterException) {
			MaxCharacterException mce = (MaxCharacterException)object;

			return "the-field-" + mce.fieldName +
				"-cannot-contain-more-than-x-characters";
		}
		else if (object instanceof PhoneException) {
			PhoneException pe = (PhoneException)object;

			return "the-" + pe.type + "-number-must-be-ten-digits-long";
		}

		return StringPool.BLANK;
	}

	public String[] getErrorMessageMultipleArguments(Object object) {
		if (object instanceof UserUsernameException.MustBeCertainLength) {
			UserUsernameException.MustBeCertainLength uue =
				(UserUsernameException.MustBeCertainLength)object;

			return new String[] {
				String.valueOf(uue.minLength), String.valueOf(uue.maxLength)
			};
		}

		return new String[0];
	}

	public String getErrorMessageSingleArgument(Object object) {
		if (object instanceof MaxCharacterException) {
			MaxCharacterException mce = (MaxCharacterException)object;

			return String.valueOf(mce.maxCharacters);
		}
		else if (object instanceof UserBirthdayException) {
			UserBirthdayException ube = (UserBirthdayException)object;

			return String.valueOf(ube.age);
		}
		else if (object instanceof UserPasswordException.MustBeLonger) {
			UserPasswordException.MustBeLonger upe =
				(UserPasswordException.MustBeLonger)object;

			return String.valueOf(upe.length);
		}

		return StringPool.BLANK;
	}

	public String getFormattedDate(long time) {
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", themeDisplay.getLocale(),
			themeDisplay.getTimeZone());

		return dateFormat.format(new Date(time));
	}

	public String getFormattedUserResult(User user) {
		StringBundler sb = new StringBundler(7);

		sb.append(user.getFirstName());
		sb.append(StringPool.SPACE);

		String lastName = user.getLastName();

		sb.append(lastName.substring(0, 1));

		sb.append(". (");
		sb.append(user.getScreenName());
		sb.append(") - ");
		sb.append(user.getEmailAddress());

		return sb.toString();
	}

	public RenderRequest getRenderRequest() {
		return renderRequest;
	}

	public RenderResponse getRenderResponse() {
		return renderResponse;
	}

	public SearchContainer getSearchContainer(PageContext pageContext)
		throws PortalException {

		SearchContainer searchContainer = new SearchContainer(
			renderRequest, renderResponse.createRenderURL(), null,
			"no-events-were-found");

		searchContainer.setDelta(20);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			renderRequest);

		int type = (int)pageContext.getAttribute("type");

		List<AMFEvent> amfEvents = AMFEventServiceUtil.getAMFEvents(
			serviceContext, type, searchContainer.getStart(),
			searchContainer.getEnd());

		searchContainer.setResults(amfEvents);

		int total = AMFEventServiceUtil.getAMFEventsCount(serviceContext, type);

		searchContainer.setTotal(total);

		return searchContainer;
	}

	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}

	public void setRenderRequest(RenderRequest renderRequest) {
		this.renderRequest = renderRequest;
	}

	public void setRenderResponse(RenderResponse renderResponse) {
		this.renderResponse = renderResponse;
	}

	public void setThemeDisplay(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
	}

	public RenderRequest renderRequest;
	public RenderResponse renderResponse;
	public ThemeDisplay themeDisplay;

}