package org.acme;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface HelloClient {
    @GET
    @Path("/hello")
    Uni<Response> hello(@QueryParam("message") String message);
}
