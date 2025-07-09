package com.resen.resenha.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.resen.resenha.repository.ResenhaRepository;

@ExtendWith(MockitoExtension.class)
public class ResenhaService {

    @InjectMocks
    private ResenhaService resenhaService;

    @Mock
    private ResenhaRepository resenhaRepository;



}
