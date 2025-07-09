package com.product.producto.service;

import com.product.producto.model.Producto;
import com.product.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    private Producto producto;

    public Producto crearProducto() {
        producto = new Producto();
        producto.setIdProducto(producto.getIdProducto());
        producto.setNombreProducto(producto.getNombreProducto());
        producto.setMarcaProducto(producto.getMarcaProducto());
        producto.setPrecioProducto(producto.getPrecioProducto());
        producto.setStockProducto(producto.getStockProducto());
        producto.setDescripcionProducto(producto.getDescripcionProducto());
        producto.setCategoriaProducto(producto.getCategoriaProducto());
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream()
        .collect(Collectors.toList());
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto actualizarProducto(Long id, Producto producto){
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombreProducto(producto.getNombreProducto());
            existingProducto.setMarcaProducto(producto.getMarcaProducto());
            existingProducto.setPrecioProducto(producto.getPrecioProducto());
            existingProducto.setStockProducto(producto.getStockProducto());
            existingProducto.setDescripcionProducto(producto.getDescripcionProducto());
            existingProducto.setCategoriaProducto(producto.getCategoriaProducto());
            return productoRepository.save(existingProducto);
        }
        return null;
    }

    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
