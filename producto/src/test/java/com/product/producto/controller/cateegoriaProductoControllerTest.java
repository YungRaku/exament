package com.product.producto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.producto.model.categoriaProducto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class cateegoriaProductoControllerTest {
        @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearCategoriaProducto() throws Exception {
        categoriaProducto categoria = new categoriaProducto();
        categoria.setNombreCategoriaProducto("Categoria Test");

        mockMvc.perform(post("/categoria-producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(categoria)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Categoria Test"));
    }
}
