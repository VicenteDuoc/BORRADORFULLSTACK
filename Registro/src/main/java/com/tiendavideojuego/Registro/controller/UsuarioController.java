package com.tiendavideojuego.Registro.controller;

import com.tiendavideojuego.Registro.model.Usuario;
import com.tiendavideojuego.Registro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String email,
                         @RequestParam String password) {
        return usuarioService.login(email, password);
    }

    @GetMapping("/{id}")
    public Usuario obtenerPerfil(@PathVariable Long id) {
        return usuarioService.obtenerPerfil(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarPerfil(@PathVariable Long id,
                                    @RequestBody Usuario datosNuevos) {
        return usuarioService.actualizarPerfil(id, datosNuevos);
    }

    @DeleteMapping("/{id}")
    public String eliminarPerfil(@PathVariable Long id) {
        usuarioService.eliminarPerfil(id);
        return "Usuario eliminado";
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }
}