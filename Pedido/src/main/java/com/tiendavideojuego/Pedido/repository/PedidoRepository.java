package com.tiendavideojuego.Pedido.repository;

import com.tiendavideojuego.Pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
}
