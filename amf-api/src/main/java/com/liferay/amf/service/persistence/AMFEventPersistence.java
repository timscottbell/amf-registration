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

package com.liferay.amf.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.exception.NoSuchEventException;
import com.liferay.amf.model.AMFEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the amf event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Timothy Bell
 * @see com.liferay.amf.service.persistence.impl.AMFEventPersistenceImpl
 * @see AMFEventUtil
 * @generated
 */
@ProviderType
public interface AMFEventPersistence extends BasePersistence<AMFEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFEventUtil} to access the amf event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the amf events where type = &#63;.
	*
	* @param type the type
	* @return the matching amf events
	*/
	public java.util.List<AMFEvent> findByType(int type);

	/**
	* Returns a range of all the amf events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @return the range of matching amf events
	*/
	public java.util.List<AMFEvent> findByType(int type, int start, int end);

	/**
	* Returns an ordered range of all the amf events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf events
	*/
	public java.util.List<AMFEvent> findByType(int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator);

	/**
	* Returns an ordered range of all the amf events where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf events
	*/
	public java.util.List<AMFEvent> findByType(int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public AMFEvent findByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public AMFEvent fetchByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator);

	/**
	* Returns the last amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public AMFEvent findByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public AMFEvent fetchByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator);

	/**
	* Returns the amf events before and after the current amf event in the ordered set where type = &#63;.
	*
	* @param amfEventId the primary key of the current amf event
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public AMFEvent[] findByType_PrevAndNext(long amfEventId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the amf events where type = &#63; from the database.
	*
	* @param type the type
	*/
	public void removeByType(int type);

	/**
	* Returns the number of amf events where type = &#63;.
	*
	* @param type the type
	* @return the number of matching amf events
	*/
	public int countByType(int type);

	/**
	* Caches the amf event in the entity cache if it is enabled.
	*
	* @param amfEvent the amf event
	*/
	public void cacheResult(AMFEvent amfEvent);

	/**
	* Caches the amf events in the entity cache if it is enabled.
	*
	* @param amfEvents the amf events
	*/
	public void cacheResult(java.util.List<AMFEvent> amfEvents);

	/**
	* Creates a new amf event with the primary key. Does not add the amf event to the database.
	*
	* @param amfEventId the primary key for the new amf event
	* @return the new amf event
	*/
	public AMFEvent create(long amfEventId);

	/**
	* Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event that was removed
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public AMFEvent remove(long amfEventId) throws NoSuchEventException;

	public AMFEvent updateImpl(AMFEvent amfEvent);

	/**
	* Returns the amf event with the primary key or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public AMFEvent findByPrimaryKey(long amfEventId)
		throws NoSuchEventException;

	/**
	* Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	*/
	public AMFEvent fetchByPrimaryKey(long amfEventId);

	@Override
	public java.util.Map<java.io.Serializable, AMFEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the amf events.
	*
	* @return the amf events
	*/
	public java.util.List<AMFEvent> findAll();

	/**
	* Returns a range of all the amf events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @return the range of amf events
	*/
	public java.util.List<AMFEvent> findAll(int start, int end);

	/**
	* Returns an ordered range of all the amf events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amf events
	*/
	public java.util.List<AMFEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator);

	/**
	* Returns an ordered range of all the amf events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amf events
	*/
	public java.util.List<AMFEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of amf events.
	*
	* @return the number of amf events
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}