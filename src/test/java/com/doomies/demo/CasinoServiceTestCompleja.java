package com.doomies.demo;

import com.doomies.demo.service.CasinoService;
import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CasinoServiceTestCompleja {

    private UserRepository repo;
    private CasinoService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(UserRepository.class);
        service = new CasinoService(repo);
    }

    @Test
    void testUsuarioNoExiste() {

        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> service.apostar(1L, 50)
        );
    }

    @Test
    void testSaldoInsuficiente() {

        // Arrange
        User user = new User("Carlos","carlos@mail.com",25);
        user.setSaldo(10);

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        // Act + Assert
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.apostar(1L, 50)
        );

        assertEquals("Saldo insuficiente", exception.getReason());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    void testApuestaValida() {

        // Arrange (Preparación)
        User user = new User("Carlos","carlos@mail.com",25);
        user.setSaldo(500);

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        // Act (Ejecución)
        service.apostar(1L,100);

        // Assert (Verificación)
        verify(repo, times(1)).save(user);
    }
}