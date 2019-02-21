package com.padmini.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.padmini.database.Login;
import com.padmini.database.LoginDao;
import com.padmini.database.Student;
import com.padmini.database.StudentDao;
import com.padmini.model.Message;
import com.padmini.service.MessageService;

@Path("teacher")
public class MyResource {

	MessageService ms = new MessageService();
	LoginDao ld = new LoginDao();
	StudentDao sd = new StudentDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> aaa() {
		
		return ms.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Login addTeacher(Login l, @Context UriInfo uriInfo)
	 {	 
		Login newUser = ld.addUser(l);
		/*Student newStud = sd.addUser(s);
		String newId = String.valueOf(newStud.getName());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
	   return Response.created(uri)
		        .entity(newStud)
		        .build();*/
		 return newUser;	 
	 }

	@Path("/{teacherId}/students")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Student addStudent(@PathParam("teacherId") int tid, Student s)
	 {	 
		//Login newUser = ld.addUser(l);
		Student newStud = sd.addUser(s,tid);
		/*String newId = String.valueOf(newStud.getName());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
	   return Response.created(uri)
		        .entity(newStud)
		        .build(); */
		 return newStud;	 
	 }
	
}
