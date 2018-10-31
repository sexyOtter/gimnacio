package ar.edu.uade.inte.gym.serviceRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.uade.inte.gym.bean.Abono;
import ar.edu.uade.inte.gym.dao.AbonoController;
import ar.edu.uade.inte.gym.exception.Invalid;

@Path("abono")
public class AbonoRest {
	
	@Inject
	private AbonoController abonoController;

	@GET
	public Response getAll (){
		List<Abono> all = abonoController.getAll();
		return Response
                .ok(all)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response create(Abono abono){
		try {
			abonoController.create(abono);
			return Response
	                .ok(abono)
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
