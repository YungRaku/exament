package com.product.producto.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class productoModelTest {
    private Long id;
    private String nombre;
    private Double precio;

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
