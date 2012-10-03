package org.louxor.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.NonUniqueResultException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * Superclasse de base pour les DAO de l'application. <br/>
 * L'implémentation est basée sur Hibernate via Spring.
 * 
 * @param <T>
 *            La classe de l'objet concerné par le DAO
 * @param <PK>
 *            La classe de la clé primaire de cet objet.
 * @see HibernateDaoSupport
 */
public abstract class BaseDAO<T extends Object, PK extends Serializable> extends HibernateDaoSupport  {
	/** La classe de l'objet concerné par le DAO. */
	private final Class<T> objectClass;

	/**
	 * Initialise la {@link SessionFactory}.
	 * 
	 * @param sessionFactory
	 *            La session factory d'Hibernate (donnée par Spring).
	 */
	@Autowired
	public void initSessionFactory(
			@Qualifier("sessionFactory") final SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * Constructeur.
	 * 
	 * @param objectClass
	 *            La classe de l'objet déclaré pour le DAO.
	 */
	public BaseDAO(final Class<T> objectClass) {
		this.objectClass = objectClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#getObjectClass()
	 */
	public Class<T> getObjectClass() {
		return this.objectClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#load(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T load(final PK primaryKey) {
		return getHibernateTemplate().load(this.objectClass, primaryKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#refresh(java.lang.Object)
	 */
	public void refresh(final T object) {
		getHibernateTemplate().refresh(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#get(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T get(final PK primaryKey) {
		return getHibernateTemplate().get(this.objectClass, primaryKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#get(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public T get(final String primaryKey, final String entityName) {
		return (T) getHibernateTemplate().get(entityName, primaryKey);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#listAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(this.objectClass));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#listAllPageCount()
	 */
	public int listAllPageCount() {
		return listAll().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#listAll(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<T> listAll(final int first, final int max) {
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(this.objectClass),first, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#save(java.lang.Object,
	 * java.lang.String)
	 */
	public void save(final T object, String userLogin) {
		getHibernateTemplate().save(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#saveOrUpdate(java.lang.Object,
	 * java.lang.String)
	 */
	public void saveOrUpdate(final T object, String userLogin) {
		getHibernateTemplate().saveOrUpdate(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nc.gouv.pac.commons.dao.base.IBaseDAO#saveOrUpdateAll(java.util.Collection
	 * , java.lang.String)
	 */
	public void saveOrUpdateAll(final Collection<T> list, String userLogin) {
		if (list != null) {
			for (final T object : list) {
				this.saveOrUpdate(object, userLogin);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#update(java.lang.Object,
	 * java.lang.String)
	 */
	public void update(final T object, String userLogin) {
		getHibernateTemplate().update(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#delete(java.lang.Object)
	 */
	public void delete(final T object) {
		getHibernateTemplate().delete(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nc.gouv.pac.commons.dao.base.IBaseDAO#deleteAll(java.util.Collection)
	 */
	public void deleteAll(final Collection<T> list) {
		if (list != null && !list.isEmpty()) {
			for (final T o : list) {
				getHibernateTemplate().delete(o);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#evict(java.lang.Object)
	 */
	public void evict(final Object object) {
		getHibernateTemplate().evict(object);
	}

	/**
	 * Equivalent de saveOrUpdate mais permet de s'affranchir des problèmes
	 * d'objets persistants déjà chargés en session hibernate.<br>
	 * Typiquement ce type d'erreur se manifeste par
	 * {@link org.hibernate.NonUniqueObjectException}.<br>
	 * Une autre solution est de supprimer l'annotation <b>cascade</b> qui est
	 * souvent la cause de l'erreur.<br>
	 * Littérature :
	 * http://www.coderanch.com/t/216092/Object-Relational-Mapping/
	 * java/Hibernate-re-attaching-existing-objects<br>
	 * 
	 * @see HibernateTemplate#merge(Object)
	 * @param object
	 *            L'objet à mettre à jour (création ou modification).
	 * @param userLogin
	 *            Le login de l''utilisateur effectuant la sauvegarde.
	 */
	public void merge(final T object, final String userLogin) {
		getHibernateTemplate().merge(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#flush()
	 */
	public void flush() {
		getSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.gouv.pac.commons.dao.base.IBaseDAO#clear()
	 */
	public void clear() {
		getHibernateTemplate().clear();
		getSession().clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nc.gouv.pac.commons.dao.base.IBaseDAO#setCacheMode(org.hibernate.CacheMode
	 * )
	 */
	public void setCacheMode(CacheMode cacheMode) {
		getSession().setCacheMode(cacheMode);
	}


	/**
	 * Exécute la requête HQL spécifiée.
	 * 
	 * @param hqlQuery
	 *            La requête doit être en HQL. Ne doit pas être vide ou
	 *            <code>null</code>.
	 * @param parameters
	 *            Liste des paramètres. Les paramètres fonctionnent par 2 : le
	 *            1er est le nom du paramètre et le 2eme sa valeur.
	 * 
	 * @return La liste des résultats.
	 */
	protected List<?> executeHqlQuery(String hqlQuery, Object... parameters) {
		if (StringUtils.isBlank(hqlQuery)) {
			throw new NullPointerException(
					"La requete HQL ne peut pas être null ou vide.");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		if (parameters != null) {
			if (parameters.length % 2 != 0) {
				throw new IllegalArgumentException(
						"Le nombre de parametres doit être un multiple de 2");
			}
			for (int i = 0; i < parameters.length - 1; i += 2) {
				if (!(parameters[i] instanceof String)) {
					// Le ieme paramètre doit être un nom d'attribut.
					throw new IllegalArgumentException("Le paramètre n°" + i
							+ " doit être une String : " + parameters[i]);
				}
				map.put((String) parameters[i], parameters[i + 1]);
			}
		}

		return executeHqlQuery(hqlQuery, map);
	}

	/**
	 * Exécute la requête HQL spécifiée.
	 * 
	 * @param hqlQuery
	 *            La requête doit être en HQL. Ne doit pas être vide ou
	 *            <code>null</code>.
	 * @param parameters
	 *            Liste des paramètres clé/valeur.
	 * 
	 * @return La liste des résultats.
	 */
	protected List<?> executeHqlQuery(String hqlQuery,
			Map<String, Object> parameters) {
		if (StringUtils.isBlank(hqlQuery)) {
			throw new NullPointerException(
					"La requete HQL ne peut pas être null ou vide.");
		}

		Query query = getSession().createQuery(hqlQuery);
		if (parameters != null) {
			for (Entry<String, Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}

		List<?> result = query.list();
		return result;
	}

	/**
	 * Exécute la requête HQL spécifiée.
	 * 
	 * @param hqlQuery
	 *            La requête doit être en HQL. Ne doit pas être vide ou
	 *            <code>null</code>.
	 * @param parameters
	 *            Liste des paramètres sous la forme. Les paramètres
	 *            fonctionnent par 2 : le 1er est le nom du paramètre et le 2eme
	 *            sa valeur.
	 * 
	 * @return Le résultat unique de la requete.
	 * 
	 * @throws NonUniqueResultException
	 *             Si la requête retourne plus d'un résultat.
	 */
	@SuppressWarnings("unchecked")
	protected T executeUniqueHQLQuery(String hqlQuery, Object... parameters) {
		return (T) uniqueResult(executeHqlQuery(hqlQuery, parameters));
	}

	/**
	 * Donne le premier élément de la liste.
	 * 
	 * @param list
	 *            La liste.
	 * 
	 * @return Le 1er élement ou <code>null</code> si la liste est vide ou
	 *         <code>null</code>
	 * 
	 * @throws NonUniqueResultException
	 *             Si la liste contient plus d'un élément.
	 */
	protected Object uniqueResult(List<?> list) {
		if (list == null || list.isEmpty()) {
			// Pas de résultat
			return null;
		} else if (list.size() > 1) {
			// Trop de résultats
			throw new NonUniqueResultException();
		}

		return list.get(0);
	}

}
