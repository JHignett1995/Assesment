package com.qa.rest;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.ClassroomServiceImpl;

@Path("/Classroom")
public class ClassroomEndpoint {
	@Inject
	private ClassroomServiceImpl service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return service.getAll();
	}
	
	@Path("/getAClassroom")
	@GET
	@Produces({"application/json"})
	public String getAClassroom(Long theID) {
		return service.getA(theID);
	}
	
	@Path("/createAClassroom")
	@POST
	@Produces({"application/json"})
	public String createAClassroom(String createThis){
		return service.createA(createThis);
	}
	
	@Path("/updateAClassroom")
	@PUT
	@Produces({"application/json"})
	public String updateAClassroom(Long theID, String updateToThis) {
		return service.updateA(updateToThis, theID);
	}
	
	@Path("/deleteAClassroom")
	@DELETE
	@Produces({"application/json"})
	public String deleteAClassroom(Long theID) {
		return service.deleteA(theID);
	}

	public void setService(ClassroomServiceImpl service) {
		this.service = service;
	}
	
}