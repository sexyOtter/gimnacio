package ar.edu.uade.inte.gym.bean;

import javax.persistence.Entity;

@Entity
public class Profesor extends Empleado{
	
	private int precioHs;
	
	public int getPrecioHs() {
		return precioHs;
	}

	public void setPrecioHs(int precioHs) {
		this.precioHs = precioHs;
	}

}