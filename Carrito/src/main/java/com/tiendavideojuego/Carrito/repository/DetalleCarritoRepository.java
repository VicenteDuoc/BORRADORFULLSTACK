package com.tiendavideojuego.Carrito.repository;

import com.tiendavideojuego.Carrito.model.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long> {
    List<DetalleCarrito> findByCarritoId(Long carritoId);
}