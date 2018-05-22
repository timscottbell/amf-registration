<%--
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
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:tabs
	names="all,registration,login"
	param="type"
	refresh="<%= false %>"
	tabsValues="<%= StringUtil.merge(AMFEventConstants.TYPES_DISPLAY) %>"
>
	<%--<%--%>
	<%--PortletURL iteratorURL = renderResponse.createRenderURL();--%>

	<%--iteratorURL.setParameter("mvcRenderCommandName", "/monitor_events");--%>

	<%--int type = ParamUtil.getInteger(request, "type", AMFEventConstants.TYPE_ANY);--%>

	<%--iteratorURL.setParameter("type", String.valueOf(type));--%>
	<%--%>--%>

	<liferay-ui:search-container
		delta="<%= 20 %>"
		emptyResultsMessage="no-events-were-found"
		total="<%= AMFEventLocalServiceUtil.getAMFEventsCount(1) %>"
	>
		<liferay-ui:search-container-results>

			<%
			List<AMFEvent> amfEvents = AMFEventLocalServiceUtil.getAMFEvents(1, searchContainer.getStart(), searchContainer.getEnd());

			searchContainer.setResults(amfEvents);
			%>

			<liferay-ui:search-container-row
				className="com.liferay.amf.model.AMFEvent"
				escapedModel="<%= true %>"
				keyProperty="amfEventId"
				modelVar="amfEvent"
			>

				<%
				DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss", themeDisplay.getLocale(), themeDisplay.getTimeZone());

				String formattedDate = dateFormat.format(new Date(amfEvent.getCreateTime()));
				%>

				<liferay-ui:search-container-column-text value="<%= formattedDate %>" />
				<liferay-ui:search-container-column-text value="<%= amfEvent.getUserName() %>" />
				<liferay-ui:search-container-column-text value="<%= StringPool.OPEN_PARENTHESIS + amfEvent.getUserId() + StringPool.CLOSE_PARENTHESIS %>" />
				<liferay-ui:search-container-column-text value="<%= amfEvent.getIpAddress() %>" />
				<liferay-ui:search-container-column-text value="<%= AMFEventConstants.getTypeLabel(amfEvent.getType()) %>" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container-results>
	</liferay-ui:search-container>
</liferay-ui:tabs>