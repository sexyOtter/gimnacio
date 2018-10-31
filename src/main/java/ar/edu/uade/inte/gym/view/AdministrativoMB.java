package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Administrativo;
import ar.edu.uade.inte.gym.dao.AdministrativoController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class AdministrativoMB implements Serializable{

	private static final long serialVersionUID = 6811405020398971104L;

	private Administrativo administrativo = new Administrativo();
	
	private boolean editMode;
	
	@Inject
	private  AdministrativoController administrativoController;
	
	@PostConstruct
	public void init() {
	}
	
	public List<Administrativo> getAll() {
		return administrativoController.getAll();
	}

	public String showCreateView() {
		this.administrativo= new Administrativo();
		this.editMode = false;
		return "nuevoAdministrativo";
	}
	
	public String showEditView(Administrativo administrativo) {
		this.administrativo = administrativo;
		this.editMode = true;
		return "nuevoAdministrativo";
	}
	
	public String create() {
		try {
			administrativoController.create(administrativo);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admAdministrativo";
	}
	
	public String update() {
		try {
			administrativoController.update(administrativo);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admAdministrativo";
	}

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
