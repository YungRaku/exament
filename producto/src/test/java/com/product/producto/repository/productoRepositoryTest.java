package com.product.producto.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.product.producto.model.Producto;

public class productoRepositoryTest {
    @Test
    public void testGettersAndSetters() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto Test");
        producto.setPrecio(100.0);

        assertEquals(1L, producto.getId());
        assertEquals("Producto Test", producto.getNombre());
        assertEquals(100.0, producto.getPrecio());
    }
}
