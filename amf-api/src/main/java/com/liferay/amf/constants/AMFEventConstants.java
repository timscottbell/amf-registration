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

package com.liferay.amf.constants;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Timothy Bell
 */
public class AMFEventConstants {

	public static final int TYPE_ANY = -1;

	public static final int TYPE_LOGIN = 1;

	public static final int TYPE_REGISTER = 2;

	public static final int[] TYPES_DISPLAY =
		{TYPE_ANY, TYPE_REGISTER, TYPE_LOGIN};

	public static String getTypeLabel(int type) {
		if (type == TYPE_LOGIN) {
			return "login";
		}
		else if (type == TYPE_REGISTER) {
			return "registration";
		}

		return StringPool.BLANK;
	}

}