package com.kingdee;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWorld {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getResult(@QueryParam("name") String name) {
		return result(name);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String postResult(@QueryParam("name") String name) {
		return result(name);
	}
	
	private String result(String name) {
		return name+",hello!";
	}

}
