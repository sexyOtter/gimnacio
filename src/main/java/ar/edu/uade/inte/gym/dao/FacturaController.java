package ar.edu.uade.inte.gym.dao;

import javax.ejb.Stateless;

import ar.edu.uade.inte.gym.bean.Factura;

@Stateless
public class FacturaController extends EntityController<Factura>{

	private static final long serialVersionUID = 1486293642539272419L;

	@Override
	public Class<Factura> getEntityClass() {
		return Factura.class;
	}
	
}
