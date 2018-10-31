package ar.edu.uade.inte.gym.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.uade.inte.gym.bean.Clase;
import ar.edu.uade.inte.gym.bean.Profesor;

@Stateless
public class ClaseController extends EntityController<Clase>{

	private static final long serialVersionUID = 4674460184685326396L;

	@Override
	public Class<Clase> getEntityClass() {
		return Clase.class;
	}
	
	public List<Clase> porProfesor(Profesor profesor){
		EntityManager em = getEntityManager();
		String jpql = "Select e from Clase e where e.profesor = :profesor";
		TypedQuery<Clase> q = em.createQuery(jpql, Clase.class);
		q.setParameter("profesor", profesor);
		return q.getResultList();
	}
	
}
