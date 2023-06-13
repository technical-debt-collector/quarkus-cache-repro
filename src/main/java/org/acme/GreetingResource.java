package org.acme;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/hello")
@ApplicationScoped
public class GreetingResource {

    @Inject
    Cache cache;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello(@QueryParam("message") String value) {
        return cache.uppercase(value);
    }
}
