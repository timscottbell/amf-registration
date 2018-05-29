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
			<liferay-ui:error exception="<%= AddressZipException.class %>" message="the-zip-code-must-be-five-digits-long" />

			<liferay-ui:error exception="<%= AlphanumericException.class %>">
				<liferay-ui:message key="<%= amfDisplayContext.getErrorMessageKey(errorException) %>" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= MaxCharacterException.class %>">
				<liferay-ui:message arguments="<%= amfDisplayContext.getErrorMessageSingleArgument(errorException) %>" key="<%= amfDisplayContext.getErrorMessageKey(errorException) %>" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= PhoneException.class %>">
				<liferay-ui:message key="<%= amfDisplayContext.getErrorMessageKey(errorException) %>" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= RegionCodeException.class %>" message="you-must-use-liferays-state-code" />
			<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
			<liferay-ui:error exception="<%= SecurityQuestionException.class %>" message="you-must-choose-one-of-the-given-questions" />
			<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-accept-the-terms-of-use" />

			<liferay-ui:error exception="<%= UserBirthdayException.class %>">
				<liferay-ui:message arguments="<%= amfDisplayContext.getErrorMessageSingleArgument(errorException) %>" key="you-must-be-x-years-old-to-register" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="the-field-email-address-must-be-alphanumeric" />

			<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>">
				<liferay-ui:message arguments="<%= amfDisplayContext.getErrorMessageSingleArgument(errorException) %>" key="the-password-must-be-longer-than-x-characters" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithRegex.class %>" message="the-password-must-contain-one-uppercase-letter-one-number-and-one-special-character" />
			<liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="the-passwords-must-match" />

			<liferay-ui:error exception="<%= UserUsernameException.MustBeCertainLength.class %>">
				<liferay-ui:message arguments="<%= amfDisplayContext.getErrorMessageMultipleArguments(errorException) %>" key="the-username-must-be-between-x-and-x-characters-long" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= UserUsernameException.MustBeUnique.class %>" message="the-username-must-be-unique" />

			<aui:fieldset label="basic-info">
				<aui:col width="<%= 50 %>">
					<aui:input label="first-name" name="first_name" required="true" type="text" value="${first_name}" />
					<aui:input label="last-name" name="last_name" required="true" type="text" value="${last_name}" />
					<aui:input label="email-address" name="email_address" required="true" type="text" value="${email_address}" />
					<aui:input label="username" name="username" required="true" type="text" value="${username}" />

					<aui:select label="gender" name="male" required="true" value="${male}">
						<aui:option label="male" value="true" />
						<aui:option label="female" value="false" />
					</aui:select>
				</aui:col>

				<aui:col width="<%= 50 %>">
					<aui:select label="birthday-month" name="b_month" required="true" value="${b_month}">
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

					<aui:input label="birthday-day" name="b_day" required="true" type="number" value="${b_month}" />
					<aui:input label="birthday-year" name="b_year" required="true" type="number" value="${b_year}" />
					<aui:input label="password" name="password1" required="true" type="password" value="${password1}" />

					<aui:input label="confirm-password" name="password2" required="true" type="password" value="${password2}">
						<aui:validator name="equalTo">
							"#<portlet:namespace />password1"
						</aui:validator>
					</aui:input>
				</aui:col>
			</aui:fieldset>

			<aui:fieldset label="phone">
				<aui:col width="<%= 50 %>">
					<aui:input label="home-phone" name="home_phone" type="number" value="${home_phone}" />
				</aui:col>

				<aui:col width="<%= 50 %>">
					<aui:input label="mobile-phone" name="mobile_phone" type="number" value="${mobile_phone}" />
				</aui:col>
			</aui:fieldset>

			<aui:fieldset label="billing-address-us-only">
				<aui:col width="<%= 50 %>">
					<aui:input label="address-1" name="address1" required="true" type="text" value="${address1}" />
					<aui:input label="address-2" name="address2" type="text" value="${address2}" />
					<aui:input label="city" name="city" required="true" type="text" value="${city}" />
				</aui:col>

				<aui:col width="<%= 50 %>">
					<aui:input label="state" name="state" required="true" type="text" value="${state}" />
					<aui:input label="zip-code" name="zip" required="true" type="number" value="${zip}" />
				</aui:col>
			</aui:fieldset>

			<aui:fieldset label="misc">
				<aui:col width="<%= 50 %>">
					<aui:select label="security-question" name="security_question" required="true" value="${security_question}">
						<c:forEach items="<%= AMFRegistrationConstants.SECURITY_QUESTIONS %>" var="securityQuestion">
							<aui:option label="${securityQuestion}" />
						</c:forEach>
					</aui:select>
				</aui:col>

				<aui:col width="<%= 50 %>">
					<aui:input label="security-answer" name="security_answer" required="true" type="text" value="${security_answer}" />
				</aui:col>
			</aui:fieldset>

			<aui:button onClick='<%= renderResponse.getNamespace() + "viewTermsOfUse();" %>' value="terms-of-use" />
			<aui:input label="i-have-read-understand-and-agree-with-the-terms-of-use-governing-my-access-to-and-use-of-the-acme-movie-fanatic-website" name="accepted_tou" required="true" type="checkbox" value="${accepted_TOU}" />

			<aui:button-row>
				<aui:button cssClass="btn-lg" type="submit" />
			</aui:button-row>
		</aui:form>
	</c:otherwise>
</c:choose>

<aui:script>
	function <portlet:namespace />viewTermsOfUse() {
		var termsOfUseURL = "<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcRenderCommandName" value="/view_terms_of_use" /></liferay-portlet:renderURL>";

		Liferay.Util.openWindow(
			{
				dialog: {
					centered: true,
					modal: true,
					destroyOnHide: true
				},
				title: Liferay.Language.get("terms-of-use"),
				uri: termsOfUseURL
			}
		);
	}
</aui:script>