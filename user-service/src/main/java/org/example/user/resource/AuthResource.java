package org.example.user.resource;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("/auth")
@Produces(MediaType.TEXT_PLAIN)
public class AuthResource {
    @POST()
    @Path("/login/user")
    public String login(){
        String userId = "user-123";
        String role = "USER";

        return Jwt.issuer("user-service")
                .subject(userId)
                .groups(Set.of(role))
                .expiresIn(3600)
                .sign();
    }

    @POST()
    @Path("/login/admin")
    public String loginAdmin(){
        String userId = "admin-123";
        String role = "ADMIN";

        return Jwt.issuer("user-service")
                .subject(userId)
                .groups(Set.of(role))
                .expiresIn(3600)
                .sign();
    }
}
