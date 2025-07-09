package com.product.producto.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class productoModelTest {
        private Long id;
    private String nombre;
    private Double precio;
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
