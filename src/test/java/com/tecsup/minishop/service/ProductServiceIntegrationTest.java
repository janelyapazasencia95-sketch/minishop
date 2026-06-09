package com.tecsup.minishop.service;

import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Debe guardar un producto válido")
    void shouldSaveValidProduct() {

        Product product = Product.builder()
                .name("Teclado")
                .price(120.0)
                .stock(5)
                .build();

        Product saved = productService.save(product);

        assertNotNull(saved.getId());
    }

    @Test
    @DisplayName("Debe lanzar excepción si el precio es cero")
    void shouldThrowExceptionWhenPriceIsZero() {

        Product product = Product.builder()
                .name("Mouse")
                .price(0.0)
                .stock(5)
                .build();

        assertThrows(
                IllegalArgumentException.class,
                () -> productService.save(product)
        );
    }

    @Test
    @DisplayName("Debe lanzar excepción si stock es negativo")
    void shouldThrowExceptionWhenStockIsNegative() {

        Product product = Product.builder()
                .name("Monitor")
                .price(800.0)
                .stock(-1)
                .build();

        assertThrows(
                IllegalArgumentException.class,
                () -> productService.save(product)
        );
    }

    @Test
    @DisplayName("Debe listar productos")
    void shouldReturnProducts() {

        productRepository.save(
                Product.builder()
                        .name("Laptop")
                        .price(2500.0)
                        .stock(3)
                        .build()
        );

        assertFalse(productService.findAll().isEmpty());
    }

    @Test
    @DisplayName("Debe buscar producto por ID")
    void shouldFindProductById() {

        Product saved = productRepository.save(
                Product.builder()
                        .name("Impresora")
                        .price(500.0)
                        .stock(2)
                        .build()
        );

        Product found = productService.findById(saved.getId());

        assertEquals(saved.getId(), found.getId());
    }
}