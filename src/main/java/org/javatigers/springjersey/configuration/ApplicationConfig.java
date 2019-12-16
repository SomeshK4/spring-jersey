package org.javatigers.springjersey.configuration;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig{
	
	@Inject
	public ApplicationConfig() {
		packages("org.javatigers.springjersey.rs");
		//register(ObjectMapperContextResolver.class);
		register(JacksonJsonProvider.class);
	}
	
	@Provider
	public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

	    private final ObjectMapper mapper;

	    public ObjectMapperContextResolver() {
	        mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(Include.NON_NULL);
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    }

	    @Override
	    public ObjectMapper getContext(Class<?> type) {
	        return mapper;
	    }
	}

}
