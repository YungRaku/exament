package com.product.producto.service;

import com.product.producto.model.categoriaProducto;
import com.product.producto.repository.categoriaProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class categoriaProductoService {
    @Mock
    private categoriaProductoRepository categoriaRepository;

    @InjectMocks
    private categoriaProductoService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarCategoriaProducto() {
        categoriaProducto categoria = new categoriaProducto();
        categoria.setNombreCategoriaProducto("Categoria Test");

        when(categoriaRepository.save(any(categoriaProducto.class))).thenReturn(categoria);

        categoriaProducto resultado = categoriaService.save(categoria);

        assertNotNull(resultado);
        assertEquals("Categoria Test", resultado.getNombreCategoriaProducto());
        verify(categoriaRepository, times(1)).save(categoria);
    }

    private categoriaProducto save(categoriaProducto categoria) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
