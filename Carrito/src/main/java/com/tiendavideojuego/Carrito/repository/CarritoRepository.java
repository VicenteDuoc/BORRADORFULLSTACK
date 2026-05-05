package com.tiendavideojuego.Carrito.repository;

import com.tiendavideojuego.Carrito.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarritoRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByUsuarioId(Long usuarioId);
    void deleteByUsuarioId(Long usuarioId);
}