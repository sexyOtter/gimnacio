package ar.edu.uade.inte.gym.serviceRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.uade.inte.gym.bean.Socio;
import ar.edu.uade.inte.gym.dao.SocioController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Path("socio")
public class SocioRest {
	
	@Inject
	private SocioController socioController;

	@GET
	public Response getAll (){
		List<Socio> all = socioController.getAll();
		return Response
                .ok(all)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response create(Socio socio){
		try {
			socioController.create(socio);
			return Response
	                .ok(socio)
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
