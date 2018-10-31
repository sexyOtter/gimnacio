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
import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.bean.Socio;
import ar.edu.uade.inte.gym.dao.AbonoController;
import ar.edu.uade.inte.gym.dao.ServicioController;
import ar.edu.uade.inte.gym.dao.SocioController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Named
@SessionScoped
public class TipoDeClaseMB implements Serializable{

	private static final long serialVersionUID = -8888780667484643240L;

	private Socio socio = new Socio();

	private List<Servicio> servicios;
	
	private List<Abono> abonos;
	
	private long servicioSeleccionado;
	
	private long abonoSeleccionado;
	
	private boolean editMode;
	
	@Inject
	private  SocioController socioController;
	
	@Inject
	private  ServicioController servicioController;
	
	@Inject
	private  AbonoController abonoController;

	@PostConstruct
	public void init() {
		servicios = servicioController.getAll();
		abonos = abonoController.getAll();
	}
	
	public List<Socio> getAll() {
		return socioController.getAll();
	}

	public String showCreateView() {
		this.servicioSeleccionado = 0;
		this.abonoSeleccionado = 0;
		this.socio= new Socio();
		this.editMode = false;
		return "nuevoSocio";
	}
	
	public String showEditView(Socio socio) {
		this.servicioSeleccionado = 0;
		this.abonoSeleccionado = socio.getAbono().getId();
		this.socio = socio;
		this.editMode = true;
		return "nuevoSocio";
	}
	
	public String create() {
		try {
			Abono abono = abonoController.byId(abonoSeleccionado);
			socio.setAbono(abono);
			socioController.create(socio);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admSocio";
	}
	
	public String update() {
		try {
			Abono abono = abonoController.byId(abonoSeleccionado);
			socio.setAbono(abono);
			socioController.update(socio);
		} catch (Invalid e) {
			showError(e.getMessage());
			return null;
		} catch (Exception e) {
			showError("Error Interno");
			return null;
		}
		return "admSocio";
	}
	
	public void agregarServicio() {
		Servicio servicio = servicioController.byId(servicioSeleccionado);
		socio.getServicios().add(servicio);
	}
	
	public void sacarServicio(Servicio servicio) {
		socio.getServicios().remove(servicio);
	}

	private void showError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public long getServicioSeleccionado() {
		return servicioSeleccionado;
	}

	public void setServicioSeleccionado(long servicioSeleccionado) {
		this.servicioSeleccionado = servicioSeleccionado;
	}

	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<Abono> abonos) {
		this.abonos = abonos;
	}

	public long getAbonoSeleccionado() {
		return abonoSeleccionado;
	}

	public void setAbonoSeleccionado(long abonoSeleccionado) {
		this.abonoSeleccionado = abonoSeleccionado;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

}
