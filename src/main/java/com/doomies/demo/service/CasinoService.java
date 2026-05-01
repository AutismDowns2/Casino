package com.doomies.demo.service;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Random;

@Service
public class CasinoService {

    private final UserRepository userRepository;
    private final Random random = new Random();

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
            throw new IllegalArgumentException("Saldo insuficiente");
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