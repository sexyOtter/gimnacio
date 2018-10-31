package ar.edu.uade.inte.gym.serviceRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.uade.inte.gym.bean.Servicio;
import ar.edu.uade.inte.gym.dao.ServicioController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Path("servicio")
public class ServiciosRest {
	
	@Inject
	private ServicioController servicioController;

	@GET
	public Response getAll (){
		List<Servicio> all = servicioController.getAll();
		return Response
                .ok(all)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response create(Servicio servicio){
		try {
			servicioController.create(servicio);
			return Response
	                .ok(servicio)
	                .type(MediaType.APPLICATION_JSON)
	                .build();
		} catch (Invalid e) {
			e.printStackTrace();
			return Response
	                .status(500)
	                .entity(e.getMessage())
	                .type(MediaType.APPLICATION_JSON)
	                .build();
		}
		
    }
}
