package com.product.producto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class categoriaProductoModelTest {
    @Test
    void testGettersAndSetters() {
        categoriaProducto categoria = new categoriaProducto();
        categoria.setIdCategoriaProducto(1L);
        categoria.setNombreCategoriaProducto("Categoria Test");

        assertEquals(1L, categoria.getIdCategoriaProducto());
        assertEquals("Categoria Test", categoria.getNombreCategoriaProducto());
    }
}
