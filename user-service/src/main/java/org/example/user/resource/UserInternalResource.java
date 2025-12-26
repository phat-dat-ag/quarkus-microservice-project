package org.example.user.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.user.entity.User;
import org.example.user.service.UserService;

@Path("/internal/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserInternalResource {
    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    public User getUserByIdInternal(@PathParam("id") String id) {
        return User.findById(id);
    }
}
