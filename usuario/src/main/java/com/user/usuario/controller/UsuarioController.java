package com.user.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.usuario.model.Usuario;
import com.user.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener Lista de Usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Obtener Usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Crear Usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(createdUsuario);
    }

    // Actualizar Usuario
    @PutMapping("/{id}")
    public Usuario updateUsuario(Long id, Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // Eliminar Usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(Long id) {    
        usuarioService.deleteUsuario(id);
    }

    // Obtener Rol de Usuario por ID
    @GetMapping("/{id}")
    public void getRolUsuarioById(Long id) {
        usuarioService.getRolUsuarioById(id);
    }

}
