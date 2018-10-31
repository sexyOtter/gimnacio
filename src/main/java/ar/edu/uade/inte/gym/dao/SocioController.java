package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Socio;

@Stateless
public class SocioController extends EntityController<Socio>{

	private static final long serialVersionUID = -4094194824415288693L;

	@Override
	public Class<Socio> getEntityClass() {
		return Socio.class;
	}
	
}
