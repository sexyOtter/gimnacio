package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.dao.ServicioController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class ServicioMB implements Serializable{

	private static final long serialVersionUID = -1995073883183596044L;

	private Servicio servicio;

	@Inject
	private  ServicioController servicioController;

	public List<Servicio> getAll() {
		return servicioController.getAll();
	}

	public String create() {
		try {
			servicioController.create(servicio);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return null;
	}

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

}
