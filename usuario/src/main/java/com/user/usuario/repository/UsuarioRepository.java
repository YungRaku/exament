package com.user.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
