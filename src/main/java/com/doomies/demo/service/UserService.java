package com.doomies.demo.service;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
        private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> obtenerUsuarios() {
        return repo.findAll();
    }

public User crearUsuario(User user) {

    if(user.getEdad() < 18){
        throw new IllegalArgumentException("El usuario debe ser mayor de edad");
    }

    if(user.getEmail() == null || user.getEmail().isBlank()){
        throw new IllegalArgumentException("Email obligatorio");
    }

    return repo.save(user);
}

public User obtenerUsuario(Long id) {
    return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
}

    public void eliminarUsuario(Long id) {
        repo.deleteById(id);
    }
}
