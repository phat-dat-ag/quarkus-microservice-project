package org.example.product.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.product.dto.ApiResponse;
import org.example.product.dto.ProductDTO;
import org.example.product.dto.ProductRequest;
import org.example.product.entity.Product;
import org.example.product.service.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    @Inject
    ProductService productService;

    @GET
    public Response getAll() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> results = products.stream().map(ProductDTO::new).toList();
        return Response.ok(ApiResponse.success(results)).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id) {
        Product product = productService.getProductById(id);
        if (product == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(ApiResponse.success(product)).build();
    }

    @POST
    public Response create(@Valid ProductRequest productRequest) {
        Product product = new Product();
        product.name = productRequest.getName();
        product.description = productRequest.getDescription();
        product.price = productRequest.getPrice();
        product.quantity = productRequest.getQuantity();
        productService.createProduct(product);
        return Response.ok(ApiResponse.success("Created product successfully")).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, @Valid ProductRequest productRequest) {
        Product product = new Product();
        product.name = productRequest.getName();
        product.description = productRequest.getDescription();
        product.price = productRequest.getPrice();
        product.quantity = productRequest.getQuantity();
        productService.updateProduct(id, product);
        return Response.ok(ApiResponse.success("Updated product successfully")).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        productService.deleteProduct(id);
        return Response.ok(ApiResponse.success("Deleted product successfully")).build();
    }
}
