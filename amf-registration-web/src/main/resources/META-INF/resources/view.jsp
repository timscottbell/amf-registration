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

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<liferay-ui:message key="you-are-already-signed-in" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="/submit_registration" var="submitRegistrationURL">
			<portlet:param name="mvcRenderCommandName" value="/submit_registration" />
		</portlet:actionURL>

		<aui:form action="<%= submitRegistrationURL %>" method="post" name="fm">
			<aui:fieldset label="basic-info">
				<aui:input label="first-name" name="first_name" required="true" type="text" />
				<aui:input label="last-name" name="last_name" required="true" type="text" />
				<aui:input label="email-address" name="email_address" required="true" type="text" />
				<aui:input label="username" name="username" required="true" type="text" />

				<aui:select label="gender" name="male" required="true">
					<aui:option label="male" value="true" />
					<aui:option label="female" value="false" />
				</aui:select>

				<aui:select label="birthday-month" name="birthdayMonth" required="true">
					<aui:option label="january" value="<%= Calendar.JANUARY %>" />
					<aui:option label="february" value="<%= Calendar.FEBRUARY %>" />
					<aui:option label="march" value="<%= Calendar.MARCH %>" />
					<aui:option label="april" value="<%= Calendar.APRIL %>" />
					<aui:option label="may" value="<%= Calendar.MAY %>" />
					<aui:option label="june" value="<%= Calendar.JUNE %>" />
					<aui:option label="july" value="<%= Calendar.JULY %>" />
					<aui:option label="august" value="<%= Calendar.AUGUST %>" />
					<aui:option label="september" value="<%= Calendar.SEPTEMBER %>" />
					<aui:option label="october" value="<%= Calendar.OCTOBER %>" />
					<aui:option label="november" value="<%= Calendar.NOVEMBER %>" />
					<aui:option label="december" value="<%= Calendar.DECEMBER %>" />
				</aui:select>

				<aui:input label="birthday-day" name="birthdayDay" required="true" type="text" value="1" />
				<aui:input label="birthday-year" name="birthdayYear" required="true" type="text" value="1970" />
				<aui:input label="password" name="password1" required="true" type="password" />

				<aui:input label="confirm-password" name="password2" required="true" type="password">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>
				</aui:input>
			</aui:fieldset>

			<aui:fieldset label="phone">
				<aui:input label="home-phone" name="home_phone" type="text" />
				<aui:input label="mobile-phone" name="mobile_phone" type="text" />
			</aui:fieldset>

			<aui:fieldset label="billing-address">
				<aui:input label="address-1" name="address1" required="true" type="text" />
				<aui:input label="address-2" name="address2" type="text" />
				<aui:input label="city" name="city" required="true" type="text" />
				<aui:input label="state" name="state" required="true" type="text" />
				<aui:input label="zip-code" name="zip" required="true" type="text" />
			</aui:fieldset>

			<aui:fieldset label="misc">
				<aui:select label="security-question" name="security_question" required="true">

					<%
					for (String securityQuestion : AMFRegistrationConstants.SECURITY_QUESTIONS) {
					%>

						<aui:option label="<%= securityQuestion %>" />

					<%
					}
					%>

				</aui:select>

				<aui:input label="answer" name="answer" required="true" type="text" />
				<aui:button onClick='<%= renderResponse.getNamespace() + "viewTermsOfUse();" %>' value="terms-of-use" />
				<aui:input label="i-have-read-understand-and-agree-with-the-terms-of-use-governing-my-access-to-and-use-of-the-acme-movie-fanatic-website" name="accepted_tou" required="true" type="checkbox" />
			</aui:fieldset>

			<aui:button-row>
				<aui:button cssClass="btn-lg" type="submit" />
			</aui:button-row>
		</aui:form>
	</c:otherwise>
</c:choose>

<aui:script>
	function <portlet:namespace />viewTermsOfUse() {
		var termsOfUseURL = '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcRenderCommandName" value="/terms_of_use" /></liferay-portlet:renderURL>';

		Liferay.Util.openWindow(
			{
				dialog: {
					centered: true,
					modal: true,
					destroyOnHide: true
				},
				title: Liferay.Language.get('terms-of-use'),
				uri: termsOfUseURL
			}
		);
	}
</aui:script>