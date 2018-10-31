package ar.edu.uade.inte.gym.bean;

import javax.persistence.Entity;

@Entity
public class Administrativo extends Empleado{
	
	private int presentismo;

	public int getPresentismo() {
		return presentismo;
	}

	public void setPresentismo(int presentismo) {
		this.presentismo = presentismo;
	}
	
}