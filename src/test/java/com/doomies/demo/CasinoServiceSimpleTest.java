package com.doomies.demo;

import com.doomies.demo.service.CasinoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasinoServiceSimpleTest {

    @Test
    void testMontoInvalido() {

        CasinoService service = new CasinoService(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.apostar(1L, -50)
        );
    }
}