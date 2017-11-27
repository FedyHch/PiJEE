package esprit.cga.resources;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entitys.Tow;
import Services.TowServiceEjbLocal;
@Path("tow")
@RequestScoped
public class TowRessources {
	@EJB
	private TowServiceEjbLocal towServiceLocal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTow(){
		return Response.status(Status.OK).entity(towServiceLocal.getAllTow()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response ajouterTow(Tow t)
	{ 
		towServiceLocal.addTow(t);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response supprimerTowById(@PathParam("id") int id)
	{
		Tow tow = towServiceLocal.findTowById(id);	
		towServiceLocal.DeleteTow(tow);
		return Response.status(Status.OK).build();

	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTow(@PathParam("id") int id, Tow t)
	{
		Tow tow = towServiceLocal.findTowById(id);

		tow.setDate_tow(t.getDate_tow());
		tow.setZone(t.getZone());
		tow.setStatus(t.getStatus());
		towServiceLocal.updateTow(tow);
		return Response.status(Status.OK).build();

	}
	
	
}
