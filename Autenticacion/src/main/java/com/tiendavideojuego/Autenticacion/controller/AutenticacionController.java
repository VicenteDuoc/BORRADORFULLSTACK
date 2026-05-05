package com.tiendavideojuego.Autenticacion.controller;

import com.tiendavideojuego.Autenticacion.service.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autenticar")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email,
                                        @RequestParam String password) {
        String token = autenticacionService.login(email, password);
        return ResponseEntity.ok(token);
    }

    // Validar token
    @GetMapping("/validar")
    public ResponseEntity<Boolean> validar(@RequestParam String token) {
        return ResponseEntity.ok(autenticacionService.validarToken(token));
    }

    // Obtener email del token
    @GetMapping("/email")
    public ResponseEntity<String> obtenerEmail(@RequestParam String token) {
        return ResponseEntity.ok(autenticacionService.obtenerEmail(token));
    }
}