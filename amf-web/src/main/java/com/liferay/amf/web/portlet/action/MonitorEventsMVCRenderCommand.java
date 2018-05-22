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

import com.liferay.amf.constants.AMFEventConstants;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.service.AMFEventLocalService;
import com.liferay.amf.web.constants.AMFPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

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
		"javax.portlet.name=" + AMFPortletKeys.AMF_EVENT_MONITORING,
		"mvc.command.name=/monitor_events"
	}
)
public class MonitorEventsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		int type = ParamUtil.getInteger(
			renderRequest, "type", AMFEventConstants.TYPE_ANY);
		int start = ParamUtil.getInteger(renderRequest, "start");
		int end = ParamUtil.getInteger(renderRequest, "end");

		List<AMFEvent> amfEvents = null;
		int amfEventsCount = 0;

		if (type != AMFEventConstants.TYPE_ANY) {
			amfEvents = _amfEventLocalService.getAMFEvents(type, start, end);

			amfEventsCount = _amfEventLocalService.getAMFEventsCount(type);
		}
		else {
			amfEvents = _amfEventLocalService.getAMFEvents(start, end);

			amfEventsCount = _amfEventLocalService.getAMFEventsCount();
		}

		renderRequest.setAttribute("results", amfEvents);
		renderRequest.setAttribute("total", amfEventsCount);

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/monitor_events");
		portletURL.setParameter("type", String.valueOf(type));

		renderRequest.setAttribute("monitorEventsURL", portletURL);

		return "/monitor_events.jsp";
	}

	@Reference
	private AMFEventLocalService _amfEventLocalService;

}