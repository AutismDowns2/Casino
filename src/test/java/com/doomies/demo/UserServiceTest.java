package com.doomies.demo;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;
import com.doomies.demo.service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    
    @Test
    void testObtenerUsuarios() {

        // Arrange (Preparación)
        UserRepository repo = Mockito.mock(UserRepository.class);

        Mockito.when(repo.findAll()).thenReturn(
                List.of(new User("Juan","juan@mail.com",25))
        );

        UserService service = new UserService(repo);
        
        // Act (Ejecución)
        List<User> users = service.obtenerUsuarios();
        
        // Assert (Verificación)
        assertEquals(1, users.size());
    }

}
