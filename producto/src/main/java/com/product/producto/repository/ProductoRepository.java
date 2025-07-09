package com.product.producto.repository;

import com.product.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Additional query methods (if any) go here

}
