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
import com.liferay.amf.service.AMFRegistrationService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Timothy Bell
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_SEARCH_RESULTS,
		"mvc.command.name=/", "mvc.command.name=/view_search_results"
	}
)
public class ViewSearchResultsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			int zip = ParamUtil.getInteger(renderRequest, "zip");

			renderRequest.setAttribute("zip", zip);

			int delta = ParamUtil.getInteger(renderRequest, "delta", 5);

			SearchContainer searchContainer = new SearchContainer(
				renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM,
				delta, renderResponse.createRenderURL(), null,
				"no-results-found-please-try-a-different-search-criteria");

			if (zip > 0) {
				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(
						User.class.getName(), renderRequest);

				List<User> users = _amfRegistrationService.getRegisteredUsers(
					zip, serviceContext.getScopeGroupId(),
					searchContainer.getStart(), searchContainer.getEnd());

				searchContainer.setResults(users);

				int total = _amfRegistrationService.getRegisteredUsersCount(
					zip, serviceContext.getScopeGroupId());

				searchContainer.setTotal(total);
			}

			renderRequest.setAttribute("searchContainer", searchContainer);
		}
		catch (PortalException pe) {
			SessionErrors.add(renderRequest, pe.getClass(), pe);

			return "/search_results/error.jsp";
		}

		return "/search_results/view.jsp";
	}

	@Reference
	private AMFRegistrationService _amfRegistrationService;

}