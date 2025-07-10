package com.aunt.auntenticacion.model;
//No se puede añadir la dependencia, ni con Bash
//import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        //Raw input in postman:
    // {
    //     "idUsuario": ""
    //     "username": ""
    //     "password": ""
    // }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID UNICO", example = "1")
    private Long id;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
