package ar.edu.uade.inte.gym.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import ar.edu.uade.inte.gym.exception.Invalid;


public abstract class EntityController<T> implements Serializable {

	private static final long serialVersionUID = 6367788614399440178L;

	@PersistenceContext
	private EntityManager entityManager;
	
	public abstract Class<T> getEntityClass();
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void create(T entity) throws Invalid{
		try{
			entityManager.persist(entity);
		} catch (ValidationException e) {
			throw new Invalid(e);
		}
	}

	public T byId(long id) {
		return entityManager.find(getEntityClass(), id);
	}

	
	public void update (T entity) throws Invalid{
		try{
			entityManager.merge(entity);
		} catch (ValidationException e) {
			throw new Invalid(e);
		}
	}

	public void delete (T entity) throws Invalid{
		try{
			entityManager.merge(entity);
			entityManager.remove(entity);
		} catch (ValidationException e) {
			throw new Invalid(e);
		}
	}

	public List<T> getAll (){
		String className = getEntityClass().getSimpleName();
		String jpql = "Select e from " + className + " e";
		TypedQuery<T> q = entityManager.createQuery(jpql, getEntityClass());
		return q.getResultList();
	}
}
