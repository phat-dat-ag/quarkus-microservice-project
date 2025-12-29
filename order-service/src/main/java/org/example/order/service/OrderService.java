package org.example.order.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.order.dto.ApiResponse;
import org.example.order.dto.User;

@ApplicationScoped
public class OrderService {
    @Inject
    @RestClient
    UserClient userClient;

    public String getUserFormOrder(String id) {
        try {
            ApiResponse<User> response = userClient.getUserById(id);
            return response.data.getName();
        } catch (NotFoundException e) {
            return null;
        }
    }
}
