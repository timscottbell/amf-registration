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

import com.liferay.amf.constants.AMFEventConstants;
import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.AMFEventService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Timothy Bell
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_EVENT_MONITOR,
		"mvc.command.name=/", "mvc.command.name=/view_events"
	}
)
public class ViewEventsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			return tryRender(renderRequest, renderResponse);
		}
		catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	public String tryRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortalException {

		int delta = ParamUtil.getInteger(
			renderRequest, "delta", SearchContainer.DEFAULT_DELTA);

		renderRequest.setAttribute("delta", delta);

		PortletURL portletURL = renderResponse.createRenderURL();

		String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "all");

		portletURL.setParameter("tabs1", tabs1);

		SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta,
			portletURL, null, "no-events-were-found");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			renderRequest);

		int type = 0;

		if (StringUtil.equalsIgnoreCase(tabs1, "all")) {
			type = AMFEventConstants.TYPE_ANY;
		}
		else if (StringUtil.equalsIgnoreCase(tabs1, "registration")) {
			type = AMFEventConstants.TYPE_REGISTER;
		}
		else if (StringUtil.equalsIgnoreCase(tabs1, "login")) {
			type = AMFEventConstants.TYPE_LOGIN;
		}

		List<AMFEvent> amfEvents = _amfEventService.getAMFEvents(
			serviceContext, type, searchContainer.getStart(),
			searchContainer.getEnd());

		searchContainer.setResults(amfEvents);

		int total = _amfEventService.getAMFEventsCount(serviceContext, type);

		searchContainer.setTotal(total);

		renderRequest.setAttribute("searchContainer", searchContainer);

		return "/view_events.jsp";
	}

	@Reference
	private AMFEventService _amfEventService;

}