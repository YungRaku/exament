package com.product.producto.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.product.producto.model.Producto;

public class productoRepositoryTest {
    @Test
    public void testGettersAndSetters() {
        Producto producto = new Producto();
        producto.setIdProducto(1L);
        producto.setNombreProducto("Producto Test");
        producto.setPrecioProducto(100.0);

        assertEquals(1L, producto.getIdProducto());
        assertEquals("Producto Test", producto.getNombreProducto());
        assertEquals(100.0, producto.getPrecioProducto());
    }
}
