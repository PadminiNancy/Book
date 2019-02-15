package com.padmini.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/inject")
@Produces(MediaType.TEXT_PLAIN)
//@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemo {
	
	 @GET
	 @Path("annotations")
	   
	    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
	    		                                @HeaderParam("custom") String header) {
	        return "MatrixParam : "+matrixParam+" HeaderParam is "+header;
	    }
	 
	 @GET
	 @Path("context")
	 public String getParamUsingContext(@Context UriInfo uri, @Context HttpHeaders header )
	 {
		 String path = uri.getAbsolutePath().toString();
		 String cookies=header.getCookies().toString();
		 return "Path is : "+path+" Cookies : "+cookies;
	 }
}
