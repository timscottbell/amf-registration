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

<portlet:actionURL name="/search" var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="/search" />
</portlet:actionURL>

<aui:form action="<%= searchURL %>" method="post" name="fm">
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="the-zip-code-must-be-five-digits-long" />

	<aui:input label="enter-us-zip" name="zip" required="true" type="number" value='<%= ParamUtil.getString(renderRequest, "zip") %>' />

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="search" />
	</aui:button-row>
</aui:form>