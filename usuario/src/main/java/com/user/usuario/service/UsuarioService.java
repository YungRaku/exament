package com.user.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.usuario.model.Usuario;
import com.user.usuario.repository.RolRepository;
import com.user.usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }

    public Usuario createUsuario(Usuario usuario) {
    if (usuario.getIdRol() != null) {
        boolean found = false;
        var roles = rolRepository.findAll();
        for (var rol : roles) {
            if (rol.getIdRol().equals(usuario.getIdRol())) {
                usuario.setIdRol(rol.getIdRol());
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Rol no existe");
        }
    }
    return usuarioRepository.save(usuario);


    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = getUsuarioById(id);
        if (usuario.getIdRol() != null) {
            boolean found = false;
            var roles = rolRepository.findAll();
            for (var rol : roles) {
                if (rol.getIdRol().equals(usuario.getIdRol())) {
                    usuario.setIdRol(rol.getIdRol());
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new RuntimeException("Rol no existe");
            }
        }
        existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
        existingUsuario.setEmailUsuario(usuario.getEmailUsuario());
        existingUsuario.setIdRol(usuario.getIdRol());
        return usuarioRepository.save(existingUsuario);
    }


    public void deleteUsuario(Long id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepository.delete(usuario);
    }

    public String getRolUsuarioById(Long id) {
    Usuario usuario = getUsuarioById(id);
    if (usuario.getIdRol() == null) {
        throw new RuntimeException("Usuario no tiene rol asignado");
    }
    var rol = rolRepository.findById(usuario.getIdRol())
        .orElseThrow(() -> new RuntimeException("Rol no existe"));
    return rol.getNombreRol();
    }  
}