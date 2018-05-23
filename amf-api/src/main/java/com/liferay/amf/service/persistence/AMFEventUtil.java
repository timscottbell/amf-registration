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

import com.liferay.amf.model.AMFEvent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the amf event service. This utility wraps {@link com.liferay.amf.service.persistence.impl.AMFEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Timothy Bell
 * @see AMFEventPersistence
 * @see com.liferay.amf.service.persistence.impl.AMFEventPersistenceImpl
 * @generated
 */
@ProviderType
public class AMFEventUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AMFEvent amfEvent) {
		getPersistence().clearCache(amfEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFEvent> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFEvent update(AMFEvent amfEvent) {
		return getPersistence().update(amfEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFEvent update(AMFEvent amfEvent,
		ServiceContext serviceContext) {
		return getPersistence().update(amfEvent, serviceContext);
	}

	/**
	* Returns all the amf events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching amf events
	*/
	public static List<AMFEvent> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the amf events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @return the range of matching amf events
	*/
	public static List<AMFEvent> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the amf events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf events
	*/
	public static List<AMFEvent> findByUserId(long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf events
	*/
	public static List<AMFEvent> findByUserId(long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByUserId_First(long userId,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first amf event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByUserId_First(long userId,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByUserId_Last(long userId,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByUserId_Last(long userId,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the amf events before and after the current amf event in the ordered set where userId = &#63;.
	*
	* @param amfEventId the primary key of the current amf event
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public static AMFEvent[] findByUserId_PrevAndNext(long amfEventId,
		long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence()
				   .findByUserId_PrevAndNext(amfEventId, userId,
			orderByComparator);
	}

	/**
	* Removes all the amf events where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of amf events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching amf events
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the amf events where type = &#63;.
	*
	* @param type the type
	* @return the matching amf events
	*/
	public static List<AMFEvent> findByType(int type) {
		return getPersistence().findByType(type);
	}

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
	public static List<AMFEvent> findByType(int type, int start, int end) {
		return getPersistence().findByType(type, start, end);
	}

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
	public static List<AMFEvent> findByType(int type, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

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
	public static List<AMFEvent> findByType(int type, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByType(type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByType_First(int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByType_First(int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByType_Last(int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByType_Last(int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the amf events before and after the current amf event in the ordered set where type = &#63;.
	*
	* @param amfEventId the primary key of the current amf event
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public static AMFEvent[] findByType_PrevAndNext(long amfEventId, int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence()
				   .findByType_PrevAndNext(amfEventId, type, orderByComparator);
	}

	/**
	* Removes all the amf events where type = &#63; from the database.
	*
	* @param type the type
	*/
	public static void removeByType(int type) {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of amf events where type = &#63;.
	*
	* @param type the type
	* @return the number of matching amf events
	*/
	public static int countByType(int type) {
		return getPersistence().countByType(type);
	}

	/**
	* Returns all the amf events where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the matching amf events
	*/
	public static List<AMFEvent> findByU_T(long userId, int type) {
		return getPersistence().findByU_T(userId, type);
	}

	/**
	* Returns a range of all the amf events where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @return the range of matching amf events
	*/
	public static List<AMFEvent> findByU_T(long userId, int type, int start,
		int end) {
		return getPersistence().findByU_T(userId, type, start, end);
	}

	/**
	* Returns an ordered range of all the amf events where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf events
	*/
	public static List<AMFEvent> findByU_T(long userId, int type, int start,
		int end, OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence()
				   .findByU_T(userId, type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf events where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf events
	* @param end the upper bound of the range of amf events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf events
	*/
	public static List<AMFEvent> findByU_T(long userId, int type, int start,
		int end, OrderByComparator<AMFEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_T(userId, type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf event in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByU_T_First(long userId, int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByU_T_First(userId, type, orderByComparator);
	}

	/**
	* Returns the first amf event in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByU_T_First(long userId, int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByU_T_First(userId, type, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event
	* @throws NoSuchEventException if a matching amf event could not be found
	*/
	public static AMFEvent findByU_T_Last(long userId, int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByU_T_Last(userId, type, orderByComparator);
	}

	/**
	* Returns the last amf event in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	*/
	public static AMFEvent fetchByU_T_Last(long userId, int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().fetchByU_T_Last(userId, type, orderByComparator);
	}

	/**
	* Returns the amf events before and after the current amf event in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param amfEventId the primary key of the current amf event
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public static AMFEvent[] findByU_T_PrevAndNext(long amfEventId,
		long userId, int type, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence()
				   .findByU_T_PrevAndNext(amfEventId, userId, type,
			orderByComparator);
	}

	/**
	* Removes all the amf events where userId = &#63; and type = &#63; from the database.
	*
	* @param userId the user ID
	* @param type the type
	*/
	public static void removeByU_T(long userId, int type) {
		getPersistence().removeByU_T(userId, type);
	}

	/**
	* Returns the number of amf events where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the number of matching amf events
	*/
	public static int countByU_T(long userId, int type) {
		return getPersistence().countByU_T(userId, type);
	}

	/**
	* Caches the amf event in the entity cache if it is enabled.
	*
	* @param amfEvent the amf event
	*/
	public static void cacheResult(AMFEvent amfEvent) {
		getPersistence().cacheResult(amfEvent);
	}

	/**
	* Caches the amf events in the entity cache if it is enabled.
	*
	* @param amfEvents the amf events
	*/
	public static void cacheResult(List<AMFEvent> amfEvents) {
		getPersistence().cacheResult(amfEvents);
	}

	/**
	* Creates a new amf event with the primary key. Does not add the amf event to the database.
	*
	* @param amfEventId the primary key for the new amf event
	* @return the new amf event
	*/
	public static AMFEvent create(long amfEventId) {
		return getPersistence().create(amfEventId);
	}

	/**
	* Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event that was removed
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public static AMFEvent remove(long amfEventId)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().remove(amfEventId);
	}

	public static AMFEvent updateImpl(AMFEvent amfEvent) {
		return getPersistence().updateImpl(amfEvent);
	}

	/**
	* Returns the amf event with the primary key or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event
	* @throws NoSuchEventException if a amf event with the primary key could not be found
	*/
	public static AMFEvent findByPrimaryKey(long amfEventId)
		throws com.liferay.amf.exception.NoSuchEventException {
		return getPersistence().findByPrimaryKey(amfEventId);
	}

	/**
	* Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param amfEventId the primary key of the amf event
	* @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	*/
	public static AMFEvent fetchByPrimaryKey(long amfEventId) {
		return getPersistence().fetchByPrimaryKey(amfEventId);
	}

	public static java.util.Map<java.io.Serializable, AMFEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the amf events.
	*
	* @return the amf events
	*/
	public static List<AMFEvent> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AMFEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AMFEvent> findAll(int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AMFEvent> findAll(int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amf events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of amf events.
	*
	* @return the number of amf events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AMFEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFEventPersistence, AMFEventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AMFEventPersistence.class);
}