package com.resen.resenha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resen.resenha.model.Resenha;

public interface ResenhaRepository extends JpaRepository<Resenha, Long> {
    // Custom query methods can be defined here if needed

}
