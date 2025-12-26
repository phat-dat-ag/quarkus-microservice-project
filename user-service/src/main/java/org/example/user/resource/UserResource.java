package org.example.user.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.user.dto.ApiResponse;
import org.example.user.dto.UserDTO;
import org.example.user.dto.UserRequest;
import org.example.user.entity.User;
import org.example.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;

    @GET
    public Response getAll() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> results = users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return Response.ok(ApiResponse.success(results)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(ApiResponse.success(new UserDTO(user))).build();
    }

    @POST
    public Response create(@Valid UserRequest userRequest) {
        User user = new User();
        user.name = userRequest.getName();
        user.email = userRequest.getEmail();
        user.age = userRequest.getAge();

        userService.createUser(user);
        return Response.ok(ApiResponse.success("Created user successfully")).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, @Valid UserRequest userRequest) {
        User user = new User();
        user.name = userRequest.getName();
        user.email = userRequest.getEmail();
        user.age = userRequest.getAge();

        userService.updateUser(id, user);
        return Response.ok(ApiResponse.success("Updated user successfully")).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        userService.deleteUser(id);
        return Response.ok(ApiResponse.success("Deleted user successfully")).build();
    }
}
