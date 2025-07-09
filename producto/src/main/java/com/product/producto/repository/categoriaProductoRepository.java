package com.product.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product.producto.model.categoriaProducto;

public interface categoriaProductoRepository extends JpaRepository<categoriaProducto, Long> {
}
