package com.doomies.demo;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;
import com.doomies.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTestCompleja {

    private UserRepository repo;
    private UserService service;

    @BeforeEach
    void setUp() {
        repo = mock(UserRepository.class);
        service = new UserService(repo);
    }

    @Test
    void testCrearUsuarioExitoso() {

        // Arrange
        User user = new User("Carlos", "carlos@mail.com", 25);
        when(repo.save(any(User.class))).thenReturn(user);

        // Act
        User resultado = service.crearUsuario(user);

        // Assert
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Carlos", resultado.getNombre()),
                () -> assertEquals(25, resultado.getEdad())
        );

        verify(repo, times(1)).save(user);
    }

    @Test
    void testCrearUsuarioMenorEdad() {

        User user = new User("Pedro", "pedro@mail.com", 15);

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.crearUsuario(user)
        );

        assertEquals("El usuario debe ser mayor de edad", exception.getMessage());

        verify(repo, never()).save(any());
    }

    @Test
    void testObtenerUsuarioNoExiste() {

        when(repo.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.obtenerUsuario(1L)
        );

        assertEquals("Usuario no encontrado", exception.getMessage());

        verify(repo, times(1)).findById(1L);
    }

    @Test
    void testGuardarCapturandoArgumento() {

        User user = new User("Ana", "ana@mail.com", 30);
        when(repo.save(any(User.class))).thenReturn(user);

        service.crearUsuario(user);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(repo).save(captor.capture());

        User usuarioGuardado = captor.getValue();

        assertEquals("Ana", usuarioGuardado.getNombre());
        assertEquals(30, usuarioGuardado.getEdad());
    }
}