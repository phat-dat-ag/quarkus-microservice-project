package org.example.product.service;

import org.example.product.entity.Product;
import org.example.product.factory.ProductTestFactory;
import org.example.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void shouldCreateProductWhenQuantityValid(){
        Product product = ProductTestFactory.createValidProduct();

        productService.createProduct(product);
        verify(productRepository).save(product);
    }

    @Test
    void shouldThrowExceptionWhenQuantityTooLow() {
        Product product = ProductTestFactory.createInvalidProduct();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> productService.createProduct(product)
        );

        assertEquals("quantity should be greater or equal to 10", ex.getMessage());
        verifyNoInteractions(productRepository);
    }

    @Test
    void shouldReturnProductWhenFound() {
        Product product = new Product();
        when(productRepository.findById("123"))
                .thenReturn(Optional.of(product));

        Product result = productService.getProductById("123");

        assertNotNull(result);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        when(productRepository.findById("123"))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> productService.getProductById("123")
        );
    }

    @Test
    void shouldUpdateProductWhenExists() {
        Product existing = ProductTestFactory.createValidProduct();
        existing.quantity = 10;

        Product updated = ProductTestFactory.createValidProduct();
        updated.quantity = 30;

        when(productRepository.findById("123"))
                .thenReturn(Optional.of(existing));

        productService.updateProduct("123", updated);

        assertEquals(30, existing.quantity);
        verify(productRepository).save(existing);
    }

    @Test
    void shouldThrowWhenUpdatingNonExistingProduct() {
        when(productRepository.findById("123"))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> productService.updateProduct("123", new Product())
        );

        verify(productRepository, never()).save(any());
    }

    @Test
    void shouldDeleteProductById() {
        productService.deleteProduct("123");

        verify(productRepository).deleteById("123");
    }
}
