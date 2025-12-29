package org.example.order.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.order.dto.ApiResponse;
import org.example.order.dto.User;

@Path("/users")
@RegisterRestClient(configKey = "user-service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserClient {

    @GET
    @Path("/{id}")
    ApiResponse<User> getUserById(@PathParam("id") String id);
}