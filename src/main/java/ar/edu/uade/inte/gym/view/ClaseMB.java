package ar.edu.uade.inte.gym.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.uade.inte.gym.bean.Abono;
import ar.edu.uade.inte.gym.bean.Clase;
import ar.edu.uade.inte.gym.bean.Profesor;
import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.bean.Socio;
import ar.edu.uade.inte.gym.bean.TipoDeClase;
import ar.edu.uade.inte.gym.dao.AbonoController;
import ar.edu.uade.inte.gym.dao.ClaseController;
import ar.edu.uade.inte.gym.dao.ProfesorController;
import ar.edu.uade.inte.gym.dao.ServicioController;
import ar.edu.uade.inte.gym.dao.SocioController;
import ar.edu.uade.inte.gym.dao.TipoDeClaseController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class ClaseMB implements Serializable{

	private static final long serialVersionUID = -8888780667484643240L;

	private long profesorSeleccionado;
	
	private long tipoDeClaseSeleccionada;
	
	private List<TipoDeClase> tiposDeClases;
	
	private List<Profesor> profesores;
	
	private Clase clase = new Clase();
	
	private boolean editMode;
	
	@Inject
	private TipoDeClaseController tipoDeClaseController; 
	
	@Inject
	private ProfesorController profesorController; 
	
	@Inject
	private ClaseController claseController; 
	
	
	@PostConstruct
	public void init() {
		tiposDeClases = tipoDeClaseController.getAll();
		profesores = profesorController.getAll();
	}
	
	public List<Clase> getAll() {
		return claseController.getAll();
	}

	public String showCreateView() {
		clase = new Clase();
		return "nuevaClase";
	}
	
	public String create() {
		try {
			Profesor profesor = profesorController.byId(profesorSeleccionado);
			TipoDeClase tipoDeClase = tipoDeClaseController.byId(tipoDeClaseSeleccionada);
			clase.setProfesor(profesor);
			clase.setTipoDeClase(tipoDeClase);
			claseController.create(clase);
			clase = new Clase();
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admClases";
	}
	
//	public String update() {
//		try {
//			Profesor profesor = profesorController.byId(profesorSeleccionado);
//			TipoDeClase tipoDeClase = tipoDeClaseController.byId(tipoDeClaseSeleccionada);
//			clase.setProfesor(profesor);
//			clase.setTipoDeClase(tipoDeClase);
//			claseController.update(clase);
//		} catch (Invalid e) {
//			showError(e.getMessage());
//			return null;
//		} catch (Exception e) {
//			showError("Error Interno");
//			return null;
//		}
//		return "admSocio";
//	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	
	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public long getProfesorSeleccionado() {
		return profesorSeleccionado;
	}

	public void setProfesorSeleccionado(long profesorSeleccionado) {
		this.profesorSeleccionado = profesorSeleccionado;
	}

	public long getTipoDeClaseSeleccionada() {
		return tipoDeClaseSeleccionada;
	}

	public void setTipoDeClaseSeleccionada(long tipoDeClaseSeleccionada) {
		this.tipoDeClaseSeleccionada = tipoDeClaseSeleccionada;
	}

	public List<TipoDeClase> getTiposDeClases() {
		return tiposDeClases;
	}

	public void setTiposDeClases(List<TipoDeClase> tiposDeClases) {
		this.tiposDeClases = tiposDeClases;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public TipoDeClaseController getTipoDeClaseController() {
		return tipoDeClaseController;
	}

	public void setTipoDeClaseController(TipoDeClaseController tipoDeClaseController) {
		this.tipoDeClaseController = tipoDeClaseController;
	}
	
}
