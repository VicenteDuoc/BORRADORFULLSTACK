package com.tiendavideojuego.Pedido.service;

import com.tiendavideojuego.Pedido.model.Pedido;
import com.tiendavideojuego.Pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Crear pedido
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Ver un pedido
    public Pedido obtenerPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    // Ver todos los pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Ver historial de pedidos por usuario
    public List<Pedido> historialPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    // Actualizar pedido
    public Pedido actualizarPedido(Long id, Pedido datosNuevos) {
        Pedido pedido = obtenerPedido(id);
        pedido.setProducto(datosNuevos.getProducto());
        pedido.setCantidad(datosNuevos.getCantidad());
        pedido.setTotal(datosNuevos.getTotal());
        pedido.setEstado(datosNuevos.getEstado());
        pedido.setFechaEntrega(datosNuevos.getFechaEntrega());
        return pedidoRepository.save(pedido);
    }

    // Eliminar pedido
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}