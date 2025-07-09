package com.product.producto.service;

import org.springframework.stereotype.Service;
import com.product.producto.model.categoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class categoriaProductoService {
    @Autowired
    private com.product.producto.repository.categoriaProductoRepository categoriaProductoRepository;

    public List<categoriaProducto> obtenerTodasLasCategorias() {
        return categoriaProductoRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public categoriaProducto obtenerCategoriaPorId(Long id) {
        return categoriaProductoRepository.findById(id).orElse(null);
    }

    public categoriaProducto crearCategoria(categoriaProducto categoria) {
        return categoriaProductoRepository.save(categoria);
    }

    public categoriaProducto actualizarCategoria(Long id, categoriaProducto categoria) {
        categoriaProducto existingCategoria = categoriaProductoRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setNombreCategoriaProducto(categoria.getNombreCategoriaProducto());
            existingCategoria.setDescripcionCategoriaProducto(categoria.getDescripcionCategoriaProducto());
            return categoriaProductoRepository.save(existingCategoria);
        }
        return null;
    }
    public boolean eliminarCategoria(Long id) {
        if (categoriaProductoRepository.existsById(id)) {
            categoriaProductoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
