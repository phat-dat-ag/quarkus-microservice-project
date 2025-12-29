package org.example.order.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.order.dto.ApiResponse;
import org.example.order.service.OrderService;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    @Inject
    OrderService orderService;

    @GET
    @Path("{id}")
    public Response getUserFromOrder(@PathParam("id") String id) {
        String result = orderService.getUserFormOrder(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(ApiResponse.error("NOT FOUND"," User not found"))
                    .build();
        }

        return Response.ok(result).build();
    }
}
