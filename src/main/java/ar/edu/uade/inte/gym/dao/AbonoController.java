package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Abono;

@Stateless
public class AbonoController extends EntityController<Abono>{

	private static final long serialVersionUID = -6462265816138356686L;

	@Override
	public Class<Abono> getEntityClass() {
		return Abono.class;
	}
	
}
