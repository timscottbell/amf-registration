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

package com.liferay.amf.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFEventLocalService}.
 *
 * @author Timothy Bell
 * @see AMFEventLocalService
 * @generated
 */
@ProviderType
public class AMFEventLocalServiceWrapper implements AMFEventLocalService,
	ServiceWrapper<AMFEventLocalService> {
	public AMFEventLocalServiceWrapper(
		AMFEventLocalService amfEventLocalService) {
		_amfEventLocalService = amfEventLocalService;
	}

	/**
	* Adds the amf event to the database. Also notifies the appropriate model listeners.
	*
	* @param amfEvent the amf event
	* @return the amf event that was added
	*/
	@Override
	public com.liferay.amf.model.AMFEvent addAMFEvent(
		com.liferay.amf.model.AMFEvent amfEvent) {
		return _amfEventLocalService.addAMFEvent(amfEvent);
	}

	@Override
	public com.liferay.amf.model.AMFEvent addAMFEvent(long userId, int type,
		java.lang.String ipAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventLocalService.addAMFEvent(userId, type, ipAddress);
	}

	/**
	* Creates a new amf event with the primary key. Does not add the amf event to the database.
	*
	* @param amfEventId the primary key for the new amf event
	* @return the new amf event
	*/
	@Override
	public com.liferay.amf.model.AMFEvent createAMFEvent(long amfEventId) {
		return _amfEventLocalService.createAMFEvent(amfEventId);
	}

	/**
	* Deletes the amf event from the database. Also notifies the appropriate model listeners.
	*
	* @param amfEvent the amf event
	* @return the amf event that was removed
	*/
	@Override
	public com.liferay.amf.model.AMFEvent deleteAMFEvent(
		com.liferay.amf.model.AMFEvent amfEvent) {
		return _amfEventLocalService.deleteAMFEvent(amfEvent);
	}

	/**
	* Deletes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event that was removed
	* @throws PortalException if a amf event with the primary key could not be found
	*/
	@Override
	public com.liferay.amf.model.AMFEvent deleteAMFEvent(long amfEventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventLocalService.deleteAMFEvent(amfEventId);
	}

	@Override
	public com.liferay.amf.model.AMFEvent fetchAMFEvent(long amfEventId) {
		return _amfEventLocalService.fetchAMFEvent(amfEventId);
	}

	/**
	* Returns the amf event with the primary key.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event
	* @throws PortalException if a amf event with the primary key could not be found
	*/
	@Override
	public com.liferay.amf.model.AMFEvent getAMFEvent(long amfEventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventLocalService.getAMFEvent(amfEventId);
	}

	/**
	* Updates the amf event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfEvent the amf event
	* @return the amf event that was updated
	*/
	@Override
	public com.liferay.amf.model.AMFEvent updateAMFEvent(
		com.liferay.amf.model.AMFEvent amfEvent) {
		return _amfEventLocalService.updateAMFEvent(amfEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _amfEventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfEventLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _amfEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of amf events.
	*
	* @return the number of amf events
	*/
	@Override
	public int getAMFEventsCount() {
		return _amfEventLocalService.getAMFEventsCount();
	}

	@Override
	public int getAMFEventsCount(int type) {
		return _amfEventLocalService.getAMFEventsCount(type);
	}

	@Override
	public int getAMFEventsCount(long userId, int type) {
		return _amfEventLocalService.getAMFEventsCount(userId, type);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfEventLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _amfEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _amfEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _amfEventLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the amf events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @return the range of amf events
	*/
	@Override
	public java.util.List<com.liferay.amf.model.AMFEvent> getAMFEvents(
		int start, int end) {
		return _amfEventLocalService.getAMFEvents(start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.model.AMFEvent> getAMFEvents(
		int type, int start, int end) {
		return _amfEventLocalService.getAMFEvents(type, start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.model.AMFEvent> getAMFEvents(
		long userId, int type, int start, int end) {
		return _amfEventLocalService.getAMFEvents(userId, type, start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _amfEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _amfEventLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public AMFEventLocalService getWrappedService() {
		return _amfEventLocalService;
	}

	@Override
	public void setWrappedService(AMFEventLocalService amfEventLocalService) {
		_amfEventLocalService = amfEventLocalService;
	}

	private AMFEventLocalService _amfEventLocalService;
}