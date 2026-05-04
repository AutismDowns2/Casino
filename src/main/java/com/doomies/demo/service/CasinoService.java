package com.doomies.demo.service;

import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;

@Service
public class CasinoService {

    private final UserRepository userRepository;
    private final SecureRandom random = new SecureRandom();

    public CasinoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String apostar(Long userId, double monto) {

        validarMonto(monto);

        User user = obtenerUsuario(userId);

        validarSaldo(user, monto);

        boolean gana = random.nextBoolean();

        return procesarResultado(user, monto, gana);
    }

    // 🔹 Métodos auxiliares (bajan complejidad)

    private void validarMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
    }

    private User obtenerUsuario(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("Usuario no encontrado");
        }

        return userOptional.get();
    }

    private void validarSaldo(User user, double monto) {
        if (user.getSaldo() < monto) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    private String procesarResultado(User user, double monto, boolean gana) {

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