package com.resen.resenha.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.resen.resenha.model.Resenha;
import com.resen.resenha.service.ResenhaService;

@WebMvcTest(ResenhaController.class)
public class ResenhaController {

    @MockBean
    private ResenhaService resenhaService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllResenhas(){

        List<Resenha> mockList = Arrays.asList(new Resenha(1L,1L,1L,"Reseña",10));
        when(resenhaService.obtenerTodasLasResenhas()).thenReturn(mockList);

        try{
            mockMvc.perform(get("/api/resenhas"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].idResenha").value(1L));
        }catch(Exception e){

        }
    }

    @Test
    void testFindPorId() throws Exception {
        Long id = 1L;
        Resenha resenha = new Resenha(1L,1L,1L,"Reseña",10);
        when(resenhaService.obtenerResenhaPorId(id)).thenReturn(resenha);

        try{
        mockMvc.perform(get("/api/resenhas/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResenha").value(1L));
        }catch (Exception e){

        }
    }

    @Test
    void testCreateResenha(){
        Resenha resenha = new Resenha(1L,1L,1L,"Reseña",10);
        when(resenhaService.crearResenha(any(Resenha.class))).thenReturn(resenha);

        try{
            mockMvc.perform(post("api/resenhas")
                    .contentType("application/json")
                    .content("""
                                {
                                    "idUsuario": "1",     
                                    "idProducto": "1",    
                                    "descripcionResenha": "Reseña",    
                                    "puntuacionResenha": "10" }
                            """))
                    .andExpect(status().isCreated());
        } catch (Exception e) {

        }
    }

}
