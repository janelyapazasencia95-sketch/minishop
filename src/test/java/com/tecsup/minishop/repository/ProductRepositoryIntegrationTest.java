package com.tecsup.minishop.repository;

import com.tecsup.minishop.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Debe guardar un producto")
    void shouldSaveProduct() {

        Product product = Product.builder()
                .name("Laptop Lenovo")
                .price(2500.0)
                .stock(10)
                .build();

        Product saved = productRepository.save(product);

        assertNotNull(saved.getId());
        assertEquals("Laptop Lenovo", saved.getName());
    }

    @Test
    @DisplayName("Debe buscar por nombre")
    void shouldFindByNameContaining() {

        productRepository.save(
                Product.builder()
                        .name("Mouse Logitech")
                        .price(80.0)
                        .stock(15)
                        .build()
        );

        List<Product> result =
                productRepository.findByNameContainingIgnoreCase("logitech");

        assertFalse(result.isEmpty());
    }
}