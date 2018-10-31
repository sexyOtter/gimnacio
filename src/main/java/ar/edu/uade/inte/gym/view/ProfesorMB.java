package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Profesor;
import ar.edu.uade.inte.gym.dao.ProfesorController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class ProfesorMB implements Serializable{
	
	private static final long serialVersionUID = -5353316441990828038L;

	private Profesor profesor = new Profesor();
	
	private boolean editMode;
	
	@Inject
	private  ProfesorController profesorController;
	
	@PostConstruct
	public void init() {
	}
	
	public List<Profesor> getAll() {
		return profesorController.getAll();
	}

	public String showCreateView() {
		this.profesor= new Profesor();
		this.editMode = false;
		return "nuevoProfesor";
	}
	
	public String showEditView(Profesor profesor) {
		this.profesor = profesor;
		this.editMode = true;
		return "nuevoProfesor";
	}
	
	public String create() {
		try {
			profesorController.create(profesor);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admProfesor";
	}
	
	public String update() {
		try {
			profesorController.update(profesor);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admProfesor";
	}

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
