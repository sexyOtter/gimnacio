package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Abono;
import ar.edu.uade.inte.gym.dao.AbonoController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class AbonoMB implements Serializable {

	private static final long serialVersionUID = -1631088367996070711L;

	private Abono abono;

	@Inject
	private  AbonoController abonoController;

	public List<Abono> getAll() {
		return abonoController.getAll();
	}

	public String create() {
		try {
			abonoController.create(abono);
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
