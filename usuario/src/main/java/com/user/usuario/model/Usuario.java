package com.user.usuario.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    //Raw input in postman:
// {
//     "idRol": ""
//     "nombreUsuario": ""
//     "emailUsuario": ""
//     "telefonoUsuario": ""
//     "direccionUsuario": ""
// }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private Long idRol;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false, unique = true)
    private String emailUsuario;

    @Column(nullable = false)
    private String telefonoUsuario;

    @Column(nullable = false)
    private String direccionUsuario;

    @OneToOne
    @Column(nullable = false)
    private Long idUser;


}
