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

package com.liferay.amf.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.exception.NoSuchEventException;
import com.liferay.amf.model.AMFEvent;
import com.liferay.amf.model.impl.AMFEventImpl;
import com.liferay.amf.model.impl.AMFEventModelImpl;
import com.liferay.amf.service.persistence.AMFEventPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the amf event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Timothy Bell
 * @see AMFEventPersistence
 * @see com.liferay.amf.service.persistence.AMFEventUtil
 * @generated
 */
@ProviderType
public class AMFEventPersistenceImpl extends BasePersistenceImpl<AMFEvent>
	implements AMFEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AMFEventUtil} to access the amf event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AMFEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Integer.class.getName() },
			AMFEventModelImpl.TYPE_COLUMN_BITMASK |
			AMFEventModelImpl.CREATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the amf events where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching amf events
	 */
	@Override
	public List<AMFEvent> findByType(int type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findByType(int type, int start, int end) {
		return findByType(type, start, end, null);
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
	@Override
	public List<AMFEvent> findByType(int type, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return findByType(type, start, end, orderByComparator, true);
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
	@Override
	public List<AMFEvent> findByType(int type, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<AMFEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AMFEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFEvent amfEvent : list) {
					if ((type != amfEvent.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AMFEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByType_First(int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {
		AMFEvent amfEvent = fetchByType_First(type, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first amf event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByType_First(int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		List<AMFEvent> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByType_Last(int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {
		AMFEvent amfEvent = fetchByType_Last(type, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last amf event in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByType_Last(int type,
		OrderByComparator<AMFEvent> orderByComparator) {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<AMFEvent> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent[] findByType_PrevAndNext(long amfEventId, int type,
		OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {
		AMFEvent amfEvent = findByPrimaryKey(amfEventId);

		Session session = null;

		try {
			session = openSession();

			AMFEvent[] array = new AMFEventImpl[3];

			array[0] = getByType_PrevAndNext(session, amfEvent, type,
					orderByComparator, true);

			array[1] = amfEvent;

			array[2] = getByType_PrevAndNext(session, amfEvent, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEvent getByType_PrevAndNext(Session session,
		AMFEvent amfEvent, int type,
		OrderByComparator<AMFEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFEVENT_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AMFEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf events where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(int type) {
		for (AMFEvent amfEvent : findByType(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching amf events
	 */
	@Override
	public int countByType(int type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "amfEvent.type = ?";

	public AMFEventPersistenceImpl() {
		setModelClass(AMFEvent.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the amf event in the entity cache if it is enabled.
	 *
	 * @param amfEvent the amf event
	 */
	@Override
	public void cacheResult(AMFEvent amfEvent) {
		entityCache.putResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventImpl.class, amfEvent.getPrimaryKey(), amfEvent);

		amfEvent.resetOriginalValues();
	}

	/**
	 * Caches the amf events in the entity cache if it is enabled.
	 *
	 * @param amfEvents the amf events
	 */
	@Override
	public void cacheResult(List<AMFEvent> amfEvents) {
		for (AMFEvent amfEvent : amfEvents) {
			if (entityCache.getResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
						AMFEventImpl.class, amfEvent.getPrimaryKey()) == null) {
				cacheResult(amfEvent);
			}
			else {
				amfEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf event.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFEvent amfEvent) {
		entityCache.removeResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventImpl.class, amfEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMFEvent> amfEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMFEvent amfEvent : amfEvents) {
			entityCache.removeResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
				AMFEventImpl.class, amfEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf event with the primary key. Does not add the amf event to the database.
	 *
	 * @param amfEventId the primary key for the new amf event
	 * @return the new amf event
	 */
	@Override
	public AMFEvent create(long amfEventId) {
		AMFEvent amfEvent = new AMFEventImpl();

		amfEvent.setNew(true);
		amfEvent.setPrimaryKey(amfEventId);

		return amfEvent;
	}

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEventId the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent remove(long amfEventId) throws NoSuchEventException {
		return remove((Serializable)amfEventId);
	}

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent remove(Serializable primaryKey) throws NoSuchEventException {
		Session session = null;

		try {
			session = openSession();

			AMFEvent amfEvent = (AMFEvent)session.get(AMFEventImpl.class,
					primaryKey);

			if (amfEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amfEvent);
		}
		catch (NoSuchEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AMFEvent removeImpl(AMFEvent amfEvent) {
		amfEvent = toUnwrappedModel(amfEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfEvent)) {
				amfEvent = (AMFEvent)session.get(AMFEventImpl.class,
						amfEvent.getPrimaryKeyObj());
			}

			if (amfEvent != null) {
				session.delete(amfEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfEvent != null) {
			clearCache(amfEvent);
		}

		return amfEvent;
	}

	@Override
	public AMFEvent updateImpl(AMFEvent amfEvent) {
		amfEvent = toUnwrappedModel(amfEvent);

		boolean isNew = amfEvent.isNew();

		AMFEventModelImpl amfEventModelImpl = (AMFEventModelImpl)amfEvent;

		Session session = null;

		try {
			session = openSession();

			if (amfEvent.isNew()) {
				session.save(amfEvent);

				amfEvent.setNew(false);
			}
			else {
				amfEvent = (AMFEvent)session.merge(amfEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AMFEventModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { amfEventModelImpl.getType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((amfEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { amfEventModelImpl.getOriginalType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { amfEventModelImpl.getType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		entityCache.putResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
			AMFEventImpl.class, amfEvent.getPrimaryKey(), amfEvent, false);

		amfEvent.resetOriginalValues();

		return amfEvent;
	}

	protected AMFEvent toUnwrappedModel(AMFEvent amfEvent) {
		if (amfEvent instanceof AMFEventImpl) {
			return amfEvent;
		}

		AMFEventImpl amfEventImpl = new AMFEventImpl();

		amfEventImpl.setNew(amfEvent.isNew());
		amfEventImpl.setPrimaryKey(amfEvent.getPrimaryKey());

		amfEventImpl.setAmfEventId(amfEvent.getAmfEventId());
		amfEventImpl.setUserId(amfEvent.getUserId());
		amfEventImpl.setUserName(amfEvent.getUserName());
		amfEventImpl.setCreateTime(amfEvent.getCreateTime());
		amfEventImpl.setType(amfEvent.getType());
		amfEventImpl.setIpAddress(amfEvent.getIpAddress());

		return amfEventImpl;
	}

	/**
	 * Returns the amf event with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException {
		AMFEvent amfEvent = fetchByPrimaryKey(primaryKey);

		if (amfEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return amfEvent;
	}

	/**
	 * Returns the amf event with the primary key or throws a {@link NoSuchEventException} if it could not be found.
	 *
	 * @param amfEventId the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent findByPrimaryKey(long amfEventId)
		throws NoSuchEventException {
		return findByPrimaryKey((Serializable)amfEventId);
	}

	/**
	 * Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf event
	 * @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
				AMFEventImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AMFEvent amfEvent = (AMFEvent)serializable;

		if (amfEvent == null) {
			Session session = null;

			try {
				session = openSession();

				amfEvent = (AMFEvent)session.get(AMFEventImpl.class, primaryKey);

				if (amfEvent != null) {
					cacheResult(amfEvent);
				}
				else {
					entityCache.putResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
						AMFEventImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
					AMFEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return amfEvent;
	}

	/**
	 * Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfEventId the primary key of the amf event
	 * @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent fetchByPrimaryKey(long amfEventId) {
		return fetchByPrimaryKey((Serializable)amfEventId);
	}

	@Override
	public Map<Serializable, AMFEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AMFEvent> map = new HashMap<Serializable, AMFEvent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AMFEvent amfEvent = fetchByPrimaryKey(primaryKey);

			if (amfEvent != null) {
				map.put(primaryKey, amfEvent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
					AMFEventImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AMFEvent)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AMFEVENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AMFEvent amfEvent : (List<AMFEvent>)q.list()) {
				map.put(amfEvent.getPrimaryKeyObj(), amfEvent);

				cacheResult(amfEvent);

				uncachedPrimaryKeys.remove(amfEvent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AMFEventModelImpl.ENTITY_CACHE_ENABLED,
					AMFEventImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the amf events.
	 *
	 * @return the amf events
	 */
	@Override
	public List<AMFEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AMFEvent> findAll(int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AMFEvent> findAll(int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AMFEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AMFEvent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFEVENT;

				if (pagination) {
					sql = sql.concat(AMFEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFEvent amfEvent : findAll()) {
			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events.
	 *
	 * @return the number of amf events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFEVENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf event persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AMFEventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AMFEVENT = "SELECT amfEvent FROM AMFEvent amfEvent";
	private static final String _SQL_SELECT_AMFEVENT_WHERE_PKS_IN = "SELECT amfEvent FROM AMFEvent amfEvent WHERE amfEventId IN (";
	private static final String _SQL_SELECT_AMFEVENT_WHERE = "SELECT amfEvent FROM AMFEvent amfEvent WHERE ";
	private static final String _SQL_COUNT_AMFEVENT = "SELECT COUNT(amfEvent) FROM AMFEvent amfEvent";
	private static final String _SQL_COUNT_AMFEVENT_WHERE = "SELECT COUNT(amfEvent) FROM AMFEvent amfEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amfEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AMFEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AMFEvent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AMFEventPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}