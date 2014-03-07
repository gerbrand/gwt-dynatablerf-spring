package com.google.gwt.sample.dynatablerf.server;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * <p>Implementation of GWT-Locator that for looking up entities
 * via JPA. The locator is used to lookup the server-side objects/entities that back
 * the Proxy objects used at the client. This way, GWT makes synchronizing client-side
 * data with server-side data easier, while still making the difference between
 * client-side and server-side object explicit.</p>
 * <p>Since a Locator needs access to the class, you'll need to subclass
 * this class for each non-valueproxy.</p>
 * Example: {@link PersonProxy} is annotated to use {@link PersonLocator} to lookup
 * the server-side objects.
 * @author Gerbrand van Dieijen <gerbrand@vandieijen.nl>
 *
 * @param <T>
 * @param <I>
 */
public abstract class JpaEntityLocator<T, I> extends Locator<T, I> {

	@PersistenceContext
	EntityManager em;
	private Class<T> entityClass;
	private Class<I> idClass;

	public JpaEntityLocator(Class<T> entityClass, Class<I> idClass) {
		this.entityClass = entityClass;
		this.idClass = idClass;
	}

	@Override
	public T create(Class<? extends T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException("Can't instantiate "+clazz, e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Can't instantiate "+clazz, e);
		}
	}

	@Override
	public T find(Class<? extends T> clazz, I id) {
		return em.find(clazz, id);
	}

	@Override
	public Class<T> getDomainType() {
		return entityClass;
	}

	@Override
	public abstract I getId(T entity);

	@Override
	public Class<I> getIdType() {
		return idClass;
	}

	@Override
	public abstract Object getVersion(T domainObject);

}