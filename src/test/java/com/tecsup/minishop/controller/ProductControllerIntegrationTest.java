package com.tecsup.minishop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void cleanDatabase() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("POST debe crear producto")
    void shouldCreateProduct() throws Exception {

        Product product = Product.builder()
                .name("Webcam Logitech")
                .price(250.00)
                .stock(20)
                .build();

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Webcam Logitech"));
    }

    @Test
    @DisplayName("GET debe listar productos")
    void shouldReturnAllProducts() throws Exception {

        productRepository.save(
                Product.builder()
                        .name("Disco SSD")
                        .price(180.00)
                        .stock(10)
                        .build()
        );

        productRepository.save(
                Product.builder()
                        .name("RAM 16GB")
                        .price(120.00)
                        .stock(8)
                        .build()
        );

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("GET por ID debe retornar producto")
    void shouldReturnProductById() throws Exception {

        Product saved = productRepository.save(
                Product.builder()
                        .name("Impresora HP")
                        .price(350.00)
                        .stock(4)
                        .build()
        );

        mockMvc.perform(get("/api/products/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Impresora HP"));
    }
}