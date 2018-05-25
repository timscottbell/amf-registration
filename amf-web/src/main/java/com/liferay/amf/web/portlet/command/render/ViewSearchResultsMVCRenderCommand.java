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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
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

		int delta = ParamUtil.getInteger(renderRequest, "delta", 5);

		SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta,
			renderResponse.createRenderURL(), null,
			"no-results-found-please-try-a-different-search-criteria");

		int zip = ParamUtil.getInteger(renderRequest, "zip");

		if (zip > 0) {
			List<User> users = _userLocalService.dynamicQuery(
				getDynamicQuery(zip), searchContainer.getStart(),
				searchContainer.getEnd());

			searchContainer.setResults(users);

			int total = (int)_userLocalService.dynamicQueryCount(
				getDynamicQuery(zip));

			searchContainer.setTotal(total);
		}

		renderRequest.setAttribute("searchContainer", searchContainer);

		return "/view_search_results.jsp";
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

	@Reference
	private UserLocalService _userLocalService;

}