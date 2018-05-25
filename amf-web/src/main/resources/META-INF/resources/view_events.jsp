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

<portlet:renderURL var="viewEventsRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/view_events" />
</portlet:renderURL>

<liferay-ui:tabs names="all,registration,login" url="${viewEventsRenderURL}" />

<liferay-ui:search-container
	searchContainer="${searchContainer}"
>
	<liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.liferay.amf.model.AMFEvent"
			escapedModel="<%= true %>"
			keyProperty="amfEventId"
			modelVar="amfEvent"
		>
			<liferay-ui:search-container-column-text
				value="<%= amfDisplayContext.getFormattedDate(amfEvent.getCreateTime()) %>"
			/>

			<liferay-ui:search-container-column-text
				value="<%= amfEvent.getUserName() %>"
			/>

			<liferay-ui:search-container-column-text
				value="<%= StringPool.OPEN_PARENTHESIS + amfEvent.getUserId() + StringPool.CLOSE_PARENTHESIS %>"
			/>

			<liferay-ui:search-container-column-text
				value="<%= amfEvent.getIpAddress() %>"
			/>

			<liferay-ui:search-container-column-text
				translate="<%= true %>"
				value="<%= AMFEventConstants.getTypeLabel(amfEvent.getType()) %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container-results>
</liferay-ui:search-container>