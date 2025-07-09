package com.resen.resenha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resen.resenha.model.Resenha;
import com.resen.resenha.service.ResenhaService;

@RestController
@RequestMapping("/api/resenhas")
public class ResenhaController {

    @Autowired
    private ResenhaService resenhaService;

    @GetMapping("/resenhas")
    public List<Resenha> getAllResenhas() {
        return resenhaService.obtenerTodasLasResenhas();
    }

    @GetMapping("/{id}")
    public Resenha getResenhaById(Long id) {
        return resenhaService.obtenerResenhaPorId(id);
    }

    @PostMapping
    public Resenha createResenha(Resenha resenha) {
        return resenhaService.crearResenha(resenha);
    }

    @PutMapping("/{id}")
    public Resenha updateResenha(Long id, Resenha resenha) {
        return resenhaService.actualizarResenha(id, resenha);
    }

    @DeleteMapping("/{id}")
    public boolean deleteResenha(Long id) {
        return resenhaService.eliminarResenha(id);
    }

}
