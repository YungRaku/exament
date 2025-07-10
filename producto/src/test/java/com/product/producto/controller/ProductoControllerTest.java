package com.product.producto.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.product.producto.model.Producto;
import com.product.producto.repository.ProductoRepository;
import com.product.producto.service.ProductoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductoControllerTest {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearProducto() {
        Producto producto = new Producto();
        producto.setIdProducto(1L);
        producto.setNombreProducto("Producto Test");
        producto.setPrecioProducto(100.0);

        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto resultado = productoService.crearProducto();
        assertNotNull(resultado);
        assertEquals("Producto Test", resultado.getNombreProducto());
        assertEquals(100.0, resultado.getPrecioProducto());
    }
}
