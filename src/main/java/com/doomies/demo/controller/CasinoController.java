package com.doomies.demo.controller;

import com.doomies.demo.service.CasinoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casino")
public class CasinoController {

    private final CasinoService casinoService;

    public CasinoController(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @PostMapping("/apostar")
    public String apostar(
            @RequestParam Long userId,
            @RequestParam double monto
    ) {
        return casinoService.apostar(userId, monto);
    }
}