package org.louxor.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.CacheMode;

/**
 * Interface du DAO de base pour l'application.
 * <p>
 * Fourni les méthode standard DAO hibernate : get, update, save etc...
 * 
 * 
 * @param <T> La classe de l'objet concerné par le DAO.
 * @param <PK> La classe de la clé primaire.
 */
public interface IBaseDAO<T extends Object, PK extends Serializable> {
	/** Nb de resultats max pour une recherche (100). */
	public static final int MAX_RESULTS = 100;
	
	/**
	 * Fournit la classe de l'objet déclaré pour le DAO.
	 * 
	 * @return La classe de l'objet déclaré pour le DAO.
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Charge un objet à partir de sa clé primaire déclarée pour le DAO.
	 * 
	 * @param primaryKey La clé primaire.
	 * @return L'objet s'il existe, sinon une exception est levée.
	 * @see #get(Serializable) pour un chargement renvoyant <code>null</code> si l'objet n'est pas trouvé.
	 */
	public T load(PK primaryKey);
	
	/**
	 * Recharge un objet du type déclaré pour le DAO.
	 * 
	 * @param object L'objet à recharger.
	 * @see #get(Serializable) pour recharger l'objet à partir de sa clé primaire.
	 */
	public void refresh(T object);
	
	/**
	 * Charge un objet à partir de sa clé primaire déclarée pour le DAO.
	 * 
	 * @param primaryKey La clé primaire.
	 * @return L'objet s'il existe, <code>null</code> sinon.
	 */
	public T get(PK primaryKey);
	
	/**
	 * Charge un objet à partir de sa clé primaire déclarée pour le DAO.
	 * 
	 * @param primaryKey La clé primaire.
	 * @param entityName Le nom de la classe de l'objet recherché, qui peut être différent de celui déclaré pour le DAO.
	 * @return L'objet s'il existe, <code>null</code> sinon.
	 * @see #get(Serializable) pour rechercher un objet du type déclaré pour le DAO à partir de sa clé primaire.
	 */
	public T get(String primaryKey, String entityName);
	
	/**
	 * Liste tous les objets du type déclaré pour le DAO.
	 * 
	 * @return La liste de tous les objets du type déclaré pour le DAO. Ne peut pas être <code>null</code>.
	 * @see #listAllPageCount() pour compter le nombre de résultats.
	 */
	public List<T> listAll();
	
	/**
	 * Compte le nombre total d'objets du type déclaré pour le DAO.
	 * 
	 * @return Le nombre d'objets du type déclaré pour le DAO.
	 * @see #listAll()
	 */
	public int listAllPageCount();
	
	/**
	 * Liste tous les objets du type déclaré pour le DAO. <br>
	 * Méthode intégrant la notion de pagination des résultats.
	 * 
	 * @param first Décalage pour déterminer le premier résultat renvoyé (utile pour la pagination).
	 * @param max Nombre maximal de résultats renvoyés (utile pour la pagination).
	 * @return La liste de tous les objets du type déclaré pour le DAO.
	 */
	public List<T> listAll(int first, int max);
	
	
	/**
	 * Sauvegarde (crée) un objet du type déclaré pour le DAO.<br/> 
	 * <b>Important : </b>
	 * <li> Les champs {@link AbstractObject#getCreated()} et {@link AbstractObject#getUpdated()} sont mis à jour si l'objet hérite de {@link AbstractObject}
	 * <li> Les champs {@link IAuthor#getUpdatedBy()} et {@link IAuthor#getCreatedBy()} sont mis à jour si l'objet hérite de {@link IAuthor}
	 * <p>
	 * @param object L'objet à sauvegarder.
	 * @param userLogin Le login de l'utilisateur effectuant la sauvegarde.
	 * @see #saveOrUpdate(Object, String) permet de mettre à jour l'objet s'il existe déjà.
	 */
	public void save(T object, String userLogin);
	
	/**
	 * Sauvegarde (crée ou met à jour) un objet du type déclaré pour le DAO.
	 * <p>
	 * <b>Important : </b>
	 * <li> Les champs {@link AbstractObject#getCreated()} et {@link AbstractObject#getUpdated()} sont mis à jour si l'objet hérite de {@link AbstractObject}
	 * <li> Les champs {@link IAuthor#getUpdatedBy()} et {@link IAuthor#getCreatedBy()} sont mis à jour si l'objet hérite de {@link IAuthor}
	 * <p>
	 * <em>Notes : </em>
	 * Cette méthode se base sur {@link AbstractObject#isNew()} pour savoir si l'objet vient d'être créé. Or cette méthode n'est pas
	 * complétement fiable notamment en cas de flush de la session avant la sauvegarde. Voir PAC-3500.
	 * 
	 * @param object L'objet à sauvegarder.
	 * @param userLogin Le login de l'utilisateur effectuant la sauvegarde.
	 */
	public void saveOrUpdate(T object, String userLogin);
	
	/**
	 * Sauvegarde (crée ou met à jour) une {@link Collection} d'objets du type déclaré pour le DAO.
	 * 
	 * @param list La {@link Collection} d'objets à sauvegarder.
	 * @param userLogin Le login de l'utilisateur effectuant la sauvegarde.
	 * @see #saveOrUpdate(Object, String)
	 */
	public void saveOrUpdateAll(Collection<T> list, String userLogin);
	
	/**
	 * Sauvegarde (met à jour) un objet du type déclaré pour le DAO.
	 * <p>
	 * <b>Important : </b>
	 * <li> Le champ <code>update</code> est mis à jour si l'objet hérite de {@link AbstractObject}
	 * <li> Le champ <code>updatedBy</code> est mis à jour si l'objet hérite de {@link IAuthor}
	 * <p>
	 * @param object L'objet à sauvegarder.
	 * @param userLogin Le login de l'utilisateur effectuant la sauvegarde.
	 */
	public void update(T object, String userLogin);
	
	/**
	 * Supprime un objet du type déclaré pour le DAO.
	 * 
	 * @param object L'objet à supprimer.
	 */
	public void delete(T object);
	
	/**
	 * Supprime une {@link Collection} d'objets du type déclaré pour le DAO.
	 * 
	 * @param list La {@link Collection} d'objets à supprimer.
	 */
	public void deleteAll(Collection<T> list);
	
	/**
	 * Supprime un objet de la session ORM courante. <br/>Ceci peut-être utile par exemple lorsqu'on veut s'assurer que l'objet n'existe plus en
	 * mémoire suite à une suppression.
	 * 
	 * @param object L'objet à sortir de la session.
	 */
	public void evict(Object object);
	
	/**
	 * Equivalent de saveOrUpdate mais permet de s'affranchir des problèmes d'objets persistants déjà chargés en session hibernate.<br>
	 * Typiquement ce type d'erreur se manifeste par {@link org.hibernate.NonUniqueObjectException}.<br>
	 * Une autre solution est de supprimer l'annotation <b>cascade</b> qui est souvent la cause de l'erreur.<br>
	 * Littérature : http://www.coderanch.com/t/216092/Object-Relational-Mapping/java/Hibernate-re-attaching-existing-objects<br>
	 * 
	 * @param object L'objet à mettre à jour (création ou modification).
	 * @param userLogin Le login de l'utilisateur effectuant la sauvegarde.
	 */
	public void merge(T object, String userLogin);
	
	/**
	 * flush session hibernate
	 */
	public void flush();
	
	/**
	 * clear session hibernate
	 */
	public void clear();
	
	/**
	 * Init le {@link CacheMode} de la session hibernate
	 * 
	 * @param cacheMode Le nouveau <code>CacheMode</code>.
	 */
	public void setCacheMode(CacheMode cacheMode);
	
}