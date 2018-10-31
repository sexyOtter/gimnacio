package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Empleado;

@Stateless
public class EmpleadoController extends EntityController<Empleado>{

	private static final long serialVersionUID = 6509489797808821132L;

	@Override
	public Class<Empleado> getEntityClass() {
		return Empleado.class;
	}
	
}
