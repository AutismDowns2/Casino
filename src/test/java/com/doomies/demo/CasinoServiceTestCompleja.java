package com.doomies.demo;

import com.doomies.demo.service.CasinoService;
import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        // Arrange (Preparación)
        User user = new User("Carlos","carlos@mail.com",25);
        user.setSaldo(10);

        when(repo.findById(1L)).thenReturn(Optional.of(user));

         // Act + Assert (Ejecución y verificación)
        assertThrows(
                IllegalArgumentException.class,
                () -> service.apostar(1L, 50)
        );
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