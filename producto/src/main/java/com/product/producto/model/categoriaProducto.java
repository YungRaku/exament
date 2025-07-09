package com.product.producto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "categoria_producto")
public class categoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaProducto;

    @Column(name = "nombreCategoriaProducto", nullable = false)
    private String nombreCategoriaProducto;

    @Column(name = "descripcionCategoriaProducto", nullable = false)
    private String descripcionCategoriaProducto;
}
