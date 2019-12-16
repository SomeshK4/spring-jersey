package org.javatigers.springjersey.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javatigers.springjersey.service.SpringJerseyService;


@Path("/hello")
public class SpringJerseyRs {
	
	private final SpringJerseyService springJerseyService;
	
    @Inject
    public SpringJerseyRs(SpringJerseyService springJerseyService) {
    	this.springJerseyService = springJerseyService;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return springJerseyService.sayHello();
	}
}
