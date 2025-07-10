package com.user.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.usuario.model.Rol;
import com.user.usuario.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    // Obtener Lista de Roles
    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    // Obtener Rol por ID
    @GetMapping("/{id}")
    public Rol getRolById(Long id) {
        return rolService.getRolById(id).orElseThrow(() -> new RuntimeException("Rol no existe"));
    }

}
