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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.amf.constants.AMFEventConstants" %><%@
page import="com.liferay.amf.constants.AMFRegistrationConstants" %><%@
page import="com.liferay.amf.exception.AlphanumericException" %><%@
page import="com.liferay.amf.exception.MaxCharacterException" %><%@
page import="com.liferay.amf.exception.PhoneException" %><%@
page import="com.liferay.amf.exception.SecurityQuestionException" %><%@
page import="com.liferay.amf.exception.UserBirthdayException" %><%@
page import="com.liferay.amf.exception.UserEmailAddressException" %><%@
page import="com.liferay.amf.exception.UserPasswordException" %><%@
page import="com.liferay.amf.exception.UserUsernameException" %><%@
page import="com.liferay.amf.model.AMFEvent" %><%@
page import="com.liferay.portal.kernel.exception.AddressZipException" %><%@
page import="com.liferay.portal.kernel.exception.RegionCodeException" %><%@
page import="com.liferay.portal.kernel.exception.RequiredFieldException" %><%@
page import="com.liferay.portal.kernel.exception.TermsOfUseException" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.security.auth.PrincipalException" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %>

<%@ page import="java.util.Calendar" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<jsp:useBean class="com.liferay.amf.web.display.context.AMFDisplayContext" id="amfDisplayContext">
	<jsp:setProperty name="amfDisplayContext" property="renderResponse" value="${renderResponse}" />
	<jsp:setProperty name="amfDisplayContext" property="renderRequest" value="${renderRequest}" />
	<jsp:setProperty name="amfDisplayContext" property="themeDisplay" value="${themeDisplay}" />
</jsp:useBean>