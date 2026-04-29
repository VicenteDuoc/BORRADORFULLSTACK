package com.tiendavideojuego.Registro.service;

import com.tiendavideojuego.Registro.model.Usuario;
import com.tiendavideojuego.Registro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario.get();
        }
        throw new RuntimeException("Email o contraseña incorrectos");
    }

    public Usuario obtenerPerfil(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario actualizarPerfil(Long id, Usuario datosNuevos) {
        Usuario usuario = obtenerPerfil(id);
        usuario.setUsername(datosNuevos.getUsername());
        usuario.setEmail(datosNuevos.getEmail());
        usuario.setPassword(datosNuevos.getPassword());
        return usuarioRepository.save(usuario);
    }

    public void eliminarPerfil(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}