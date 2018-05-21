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

package com.liferay.amf.internal.events;

import com.liferay.amf.constants.AMFEventConstants;
import com.liferay.amf.service.AMFEventLocalService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Timothy Bell
 */
@Component(
	immediate = true, property = "key=" + PropsKeys.LOGIN_EVENTS_POST,
	service = LifecycleAction.class
)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		HttpServletRequest request = lifecycleEvent.getRequest();

		try {
			User user = _portal.getUser(request);

			_amfEventLocalService.addAMFEvent(
				user.getUserId(), AMFEventConstants.TYPE_LOGIN,
				request.getRemoteAddr());
		}
		catch (PortalException pe) {
			throw new ActionException(pe);
		}
	}

	@Reference
	private AMFEventLocalService _amfEventLocalService;

	@Reference
	private Portal _portal;

}