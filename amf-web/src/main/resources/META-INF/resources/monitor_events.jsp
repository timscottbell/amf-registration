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

<liferay-ui:tabs names="all,registration,login" refresh="<%= false %>" param="type" tabsValues="<%= StringUtil.merge(AMFEventConstants.TYPES_DISPLAY) %>">
    <liferay-ui:search-container
        delta="<%= 20 %>"
        emptyResultsMessage="no-events-were-found"
        iteratorURL="<%= (PortletURL)renderRequest.getAttribute("monitorEventsURL") %>"
        total="<%= (int)renderRequest.getAttribute("total") %>"
    >

        <liferay-ui:search-container-results results="<%= (List<AMFEvent>)renderRequest.getAttribute("results") %>">
            <liferay-ui:search-container-row
                className="com.liferay.amf.model.AMFEvent"
                keyProperty="amfEventId"
                modelVar="amfEvent"
            >
                <liferay-ui:search-container-column-text
                    value="<%= HtmlUtil.escape(amfEvent.getUserName()) %>"
                />
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator
                    markupView="lexicon"
                    paginate="<%= true %>"
            />
        </liferay-ui:search-container-results>
    </liferay-ui:search-container>
</liferay-ui:tabs>