package com.product.producto.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column(name = "marcaProducto", nullable = false)
    private String marcaProducto;

    @Column(name = "precioProducto", nullable = false)
    private Double precioProducto;

    @Column(name = "stockProducto", nullable = false)
    private Integer stockProducto;

    @Column(name = "descripcionProducto", nullable = false)
    private String descripcionProducto;

    @ManyToOne
    @JoinColumn(name = "idCategoriaProducto", nullable = false)
    private categoriaProducto categoriaProducto;
}
