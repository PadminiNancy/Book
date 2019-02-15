package com.padmini.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.padmini.model.Comment;
import com.padmini.service.CommntService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommntService cs = new CommntService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long mid)
	{		
		return cs.getAllComments(mid);
	//	return "test";
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long mid, @PathParam("commentId") long cid)
	{		
		return cs.getComment(mid, cid);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long mid, Comment comment)
	{
		
		return cs.addComment(mid, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long mid, @PathParam("commentId") long cid,Comment comment)
	{
		comment.setId(cid);
		return cs.updateComment(mid, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long mid, @PathParam("commentId") long cid)
	{		
		return cs.getComment(mid, cid);
	}
}
