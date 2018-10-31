package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Abono;
import ar.edu.uade.inte.gym.bean.Clase;
import ar.edu.uade.inte.gym.bean.ReciboDeSueldo;
import ar.edu.uade.inte.gym.bean.TipoDeClase;

@Stateless
public class TipoDeClaseController extends EntityController<TipoDeClase>{

	private static final long serialVersionUID = -5214664669428604625L;

	@Override
	public Class<TipoDeClase> getEntityClass() {
		return TipoDeClase.class;
	}
	
}
