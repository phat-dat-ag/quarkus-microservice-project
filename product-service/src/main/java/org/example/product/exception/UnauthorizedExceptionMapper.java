package org.example.product.exception;

import io.quarkus.security.UnauthorizedException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnauthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {
    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(UnauthorizedException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorResponse(
                        401,
                        "UNAUTHORIZED",
                        "Authentication is required",
                        uriInfo.getPath()
                ))
                .build();
    }
}
