package com.doomies.demo.controller;

import com.doomies.demo.model.User;
import com.doomies.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
        private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> obtenerUsuarios() {
        return service.obtenerUsuarios();
    }

    @PostMapping
    public User crearUsuario(@RequestBody User user) {
        return service.crearUsuario(user);
    }

    @GetMapping("/{id}")
    public User obtenerUsuario(@PathVariable Long id) {
        return service.obtenerUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }

}
