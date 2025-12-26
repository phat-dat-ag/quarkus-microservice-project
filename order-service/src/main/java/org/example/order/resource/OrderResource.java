package org.example.order.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.order.service.OrderService;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    @Inject
    OrderService orderService;

    @GET
    @Path("{id}")
    public String getUserFromOrder(@PathParam("id") String id) {
        return orderService.getUserFormOrder(id);
    }
}
