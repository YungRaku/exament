package com.resen.resenha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resen.resenha.model.Resenha;
import com.resen.resenha.repository.ResenhaRepository;
import com.resen.resenha.webClient.ProductoClient;
import com.resen.resenha.webClient.UsuarioClient;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResenhaService { 

    @Autowired
    private ResenhaRepository resenhaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private ProductoClient productoClient;

    public List<Resenha> obtenerTodasLasResenhas() {
        return resenhaRepository.findAll();
    }

    public Resenha obtenerResenhaPorId(Long id) {
        return resenhaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resenha no encontrada"));
    }

    public Resenha crearResenha(Resenha resenha) {
        // Validar usuario
        if (usuarioClient.getUsuarioById(resenha.getIdUsuario()) == null) {
            throw new RuntimeException("Usuario no existe");
        }
        // Validar producto
        if (productoClient.getProductoById(resenha.getIdProducto()) == null) {
            throw new RuntimeException("Producto no existe");
        }
        return resenhaRepository.save(resenha);
    }

    public Resenha actualizarResenha(Long id, Resenha resenha) {
        Resenha existingResenha = obtenerResenhaPorId(id);
        if (resenha.getIdResenha() != null) {
            throw new RuntimeException("No existe el ID de resenha");
        }
        existingResenha.setDescripcionResenha(resenha.getDescripcionResenha());
        existingResenha.setPuntuacionResenha(resenha.getPuntuacionResenha());
        return resenhaRepository.save(existingResenha);
    }

    public boolean eliminarResenha(Long id) {
        if (resenhaRepository.existsById(id)) {
            resenhaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
