package com.user.usuario.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import com.user.usuario.model.Usuario;
import com.user.usuario.repository.RolRepository;
import com.user.usuario.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testFindAllUsuarios() {
        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario, usuario2));

        List<Usuario> usuarios = usuarioService.getAllUsuarios();

        assertThat(usuarios).hasSize(2);
    }

    @Test
    void testFindUsuarioById(){
        Usuario usuario = new Usuario(1L, 1L, "Pepe","a@com","123","calle123");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        
        Optional<Usuario> foundUsuario = Optional.ofNullable(usuarioService.getUsuarioById(1L));
        assertThat(foundUsuario).isPresent();
        assertThat(foundUsuario.get().getNombreUsuario()).isEqualTo("Pepe");
    }

    @Test
    void testSaveUsuario() {
        Usuario usuario = new Usuario(1L, 1L, "Pepe","a@com","123","calle123");
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.createUsuario(usuario);

        assertThat(savedUsuario.getIdUsuario()).isEqualTo(1L);
        assertThat(savedUsuario.getNombreUsuario()).isEqualTo("Pepe");
    }


}
