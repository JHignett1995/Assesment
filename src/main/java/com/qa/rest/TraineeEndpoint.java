package com.qa.rest;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.TraineeServiceImpl;

@Path("/Trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeServiceImpl service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({"application/json"})
	public String getAllTrainees() {
		return service.getAll();
	}
	
	@Path("/getATrainee")
	@GET
	@Produces({"application/json"})
	public String getATrainee(Long theID) {
		return service.getA(theID);
	}
	
	@Path("/createATrainee")
	@POST
	@Produces({"application/json"})
	public String createATrainee(String createThis){
		return service.createA(createThis);
	}
	
	@Path("/updateATrainee")
	@PUT
	@Produces({"application/json"})
	public String updateATrainee(Long theID, String updateToThis) {
		return service.updateA(updateToThis, theID);
	}
	
	@Path("/deleteATrainee")
	@DELETE
	@Produces({"application/json"})
	public String deleteATrainee(Long theID) {
		return service.deleteA(theID);
	}

	public void setService(TraineeServiceImpl service) {
		this.service = service;
	}
	
}