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

import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.AMFEventLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;

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

	public String getFormattedDate(long time) {
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", themeDisplay.getLocale(),
			themeDisplay.getTimeZone());

		return dateFormat.format(new Date(time));
	}

	public RenderRequest getRenderRequest() {
		return renderRequest;
	}

	public RenderResponse getRenderResponse() {
		return renderResponse;
	}

	public SearchContainer getSearchContainer(PageContext pageContext) {
		SearchContainer searchContainer = new SearchContainer(
			renderRequest, renderResponse.createRenderURL(), null,
			"no-events-were-found");

		searchContainer.setDelta(20);

		int type = (int)pageContext.getAttribute("type");

		List<AMFEvent> amfEvents = AMFEventLocalServiceUtil.getAMFEvents(
			type, searchContainer.getStart(), searchContainer.getEnd());

		searchContainer.setResults(amfEvents);

		int total = AMFEventLocalServiceUtil.getAMFEventsCount(type);

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