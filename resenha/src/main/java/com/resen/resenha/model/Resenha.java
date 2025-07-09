package com.resen.resenha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reseña")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resenha {

    // Raw input in postman:
    // {
    //     "idUsuario": "",
    //     "idProducto": "",
    //     "descripcionResenha": "",
    //     "puntuacionResenha": ""
    // }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenha;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private Long idProducto;

    @Column(nullable = false)
    private String descripcionResenha;

    @Column(nullable = false)
    private int puntuacionResenha;

}
