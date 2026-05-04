package com.doomies.demo.service;

import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class CasinoService {

    private final UserRepository userRepository;


    private final SecureRandom random = new SecureRandom();

    public CasinoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String apostar(Long userId, double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        User user = userOptional.get();

        if (user.getSaldo() < monto) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        boolean gana = random.nextBoolean();

        if (gana) {
            double ganancia = monto * 2;
            user.setSaldo(user.getSaldo() + ganancia);
            userRepository.save(user);
            return "GANASTE " + ganancia;
        } else {
            user.setSaldo(user.getSaldo() - monto);
            userRepository.save(user);
            return "PERDISTE " + monto;
        }
    }
}
