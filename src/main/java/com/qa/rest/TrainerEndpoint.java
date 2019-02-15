package com.qa.rest;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.TrainerServiceImpl;

@Path("/Trainer")
public class TrainerEndpoint {
	@Inject
	private TrainerServiceImpl service;
	
	@Path("/getAllTrainers")
	@GET
	@Produces({"application/json"})
	public String getAllTrainers() {
		return service.getAll();
	}
	
	@Path("/getATrainer")
	@GET
	@Produces({"application/json"})
	public String getATrainer(Long theID) {
		return service.getA(theID);
	}
	
	@Path("/createATrainer")
	@POST
	@Produces({"application/json"})
	public String createATrainer(String createThis){
		return service.createA(createThis);
	}
	
	@Path("/updateATrainer")
	@PUT
	@Produces({"application/json"})
	public String updateATrainer(Long theID, String updateToThis) {
		return service.updateA(updateToThis, theID);
	}
	
	@Path("/deleteATrainer")
	@DELETE
	@Produces({"application/json"})
	public String deleteATrainer(Long theID) {
		return service.deleteA(theID);
	}

	public void setService(TrainerServiceImpl service) {
		this.service = service;
	}
	
}