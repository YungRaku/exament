package com.product.producto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.product.producto.model.categoriaProducto;
import java.util.List;

@RestController
@RequestMapping("/api/categoria-producto")
public class CategProductoController {
    @Autowired
    private com.product.producto.service.categoriaProductoService categoriaProductoService;

    @GetMapping
    public List<categoriaProducto> obtenerTodasLasCategorias() {
        return categoriaProductoService.obtenerTodasLasCategorias();
    }
    @GetMapping("/{id}")
    public categoriaProducto obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaProductoService.obtenerCategoriaPorId(id);
    }
}
