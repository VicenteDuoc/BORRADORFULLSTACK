package com.tiendavideojuego.Autenticacion.service;

import com.tiendavideojuego.Autenticacion.model.Usuario;
import com.tiendavideojuego.Autenticacion.repository.UsuarioRepository;
import com.tiendavideojuego.Autenticacion.security.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Jwt jwtUtil;

    // Login → devuelve token
    public String login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generarToken(email, usuario.getRol());
    }

    // Validar token
    public boolean validarToken(String token) {
        return jwtUtil.validarToken(token);
    }

    // Obtener email del token
    public String obtenerEmail(String token) {
        return jwtUtil.obtenerEmail(token);
    }
}