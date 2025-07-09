package com.user.usuario.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;


import com.user.usuario.service.UsuarioService;
import com.user.usuario.model.Usuario;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    public void testGetAllUsuarios() throws Exception {
        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();
        when(usuarioService.getAllUsuarios()).thenReturn(Arrays.asList(usuario, usuario2));
        mockMvc.perform(get("/api/usuarios/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombreUsuario").value(usuario.getNombreUsuario()))
                .andExpect(jsonPath("$[1].nombreUsuario").value(usuario2.getNombreUsuario()));
    }
    

    @Test
    public void testGetUsuarioById() throws Exception {
        Long userId = 1L;
        mockMvc.perform(get("/api/usuarios/" + userId))
                .andExpect(status().isNotFound()); 
    }

    @Test 
    void testCreateUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUser");
        when(usuarioService.createUsuario(usuario)).thenReturn(usuario);
        mockMvc.perform(get("/api/usuarios/usuarios")
                .contentType("application/json")
                .content("{\"nombreUsuario\":\"testUser\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("testUser"));  
    }

    @Test
    void testUpdateUsuario() throws Exception {
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("updatedUser");
        when(usuarioService.updateUsuario(userId, usuario)).thenReturn(usuario);
        mockMvc.perform(get("/api/usuarios/" + userId)
                .contentType("application/json")
                .content("{\"nombreUsuario\":\"updatedUser\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("updatedUser"));
    }

    @Test
    void testDeleteUsuario() throws Exception {
        Long userId = 1L;
        mockMvc.perform(get("/api/usuarios/" + userId))
                .andExpect(status().isOk()); 
    }
}
