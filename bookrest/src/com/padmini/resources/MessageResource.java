package com.padmini.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.padmini.database.Login;
import com.padmini.database.LoginDao;
import com.padmini.model.Message;
import com.padmini.resources.beans.MessageFilterBean;
import com.padmini.service.MessageService;
import com.sun.research.ws.wadl.Response.*;

@Path("messages")
public class MessageResource {
	
	MessageService ms = new MessageService();
	LoginDao ld = new LoginDao();
	
	
@GET
@Produces(MediaType.APPLICATION_JSON)
 public List<Message> getAllMessage()
 {	 
	 return ms.getAllMessages();	 
 }

/*
@GET
@Produces(MediaType.TEXT_PLAIN)
 public String getMessage(@BeanParam MessageFilterBean filterBean)
 {	 
	if(filterBean.getYear() == 2018)
		return "match found";
	else if(filterBean.getStart()>0 && filterBean.getSize()>0)
	    return"start is"+filterBean.getStart()+" and size is "+filterBean.getSize();
	else
	 return "Not found";	 
 }  */

@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
 public Message getMessage(@PathParam("messageId") long messageId)
 {	 
	 return ms.getMessage(messageId);	 
 }

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
 public Response addMessage(Login l, @Context UriInfo uriInfo)
 {	 
	Login newUser = ld.addUser(l);
	String newId = String.valueOf(newUser.getLastname());
	URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
   return Response.created(uri)
	        .entity(newUser)
	        .build();
	// return ms.addMessage(message);	 
 }

/*
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
 public Response addMessage(Message message, @Context UriInfo uriInfo)
 {	 
	Message newMessage = ms.addMessage(message);
	String newId = String.valueOf(newMessage.getId());
	URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
   return Response.created(uri)
	        .entity(newMessage)
	        .build();
	// return ms.addMessage(message);	 
 }  */

@PUT
@Path("/{messageId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
 public Message updateMessage(@PathParam("messageId") long id,Message message)
 {	 
	 message.setId(id);
	 return ms.updateMessage(message);	 
 }

@DELETE
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
 public Message deleteMessage(@PathParam("messageId") long id)
 {	 
	// message.setId(id);
	 return ms.removeMessage(id);	 
 }


@Path("/{messageId}/comments")
public CommentResource getCommentResource()
{
	
 return new CommentResource();
}

}
