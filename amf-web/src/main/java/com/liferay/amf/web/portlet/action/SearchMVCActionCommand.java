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

import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Timothy Bell
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_SEARCH,
		"mvc.command.name=/search"
	}
)
public class SearchMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		int zip = ParamUtil.getInteger(actionRequest, "zip");

		// Fetch by primary and zip and join on User

		//Communincate to other portlet

		return true;
	}

}