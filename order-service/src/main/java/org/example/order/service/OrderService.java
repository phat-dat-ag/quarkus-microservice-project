package org.example.order.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.order.dto.User;

@ApplicationScoped
public class OrderService {
    @Inject
    @RestClient
    UserClient userClient;

    public String getUserFormOrder(String id) {
        User user = userClient.getUserById(id);
        return user != null ? user.getName() : "Can not find user!";
    }
}
