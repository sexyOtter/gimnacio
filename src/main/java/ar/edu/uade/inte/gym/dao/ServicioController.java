package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Servicio;

@Stateless
public class ServicioController extends EntityController<Servicio>{

	private static final long serialVersionUID = -4856174465195742618L;

	@Override
	public Class<Servicio> getEntityClass() {
		return Servicio.class;
	}
	
}
