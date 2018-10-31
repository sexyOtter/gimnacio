package ar.edu.uade.inte.gym.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clase implements Serializable{
	
	private static final long serialVersionUID = 1635523978951895899L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private TipoDeClase tipoDeClase;
	
	@ManyToOne
	private Profesor profesor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoDeClase getTipoDeClase() {
		return tipoDeClase;
	}

	public void setTipoDeClase(TipoDeClase tipoDeClase) {
		this.tipoDeClase = tipoDeClase;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}