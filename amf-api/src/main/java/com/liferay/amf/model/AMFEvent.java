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

package com.liferay.amf.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AMFEvent service. Represents a row in the &quot;AMFEvent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Timothy Bell
 * @see AMFEventModel
 * @see com.liferay.amf.model.impl.AMFEventImpl
 * @see com.liferay.amf.model.impl.AMFEventModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.amf.model.impl.AMFEventImpl")
@ProviderType
public interface AMFEvent extends AMFEventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.amf.model.impl.AMFEventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AMFEvent, Long> AMF_EVENT_ID_ACCESSOR = new Accessor<AMFEvent, Long>() {
			@Override
			public Long get(AMFEvent amfEvent) {
				return amfEvent.getAmfEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AMFEvent> getTypeClass() {
				return AMFEvent.class;
			}
		};
}