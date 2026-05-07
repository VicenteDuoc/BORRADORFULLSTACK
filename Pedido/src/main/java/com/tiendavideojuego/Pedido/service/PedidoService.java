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

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obtenerPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> historialPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    public Pedido actualizarPedido(Long id, Pedido datosNuevos) {
        Pedido pedido = obtenerPedido(id);
        pedido.setProducto(datosNuevos.getProducto());
        pedido.setCantidad(datosNuevos.getCantidad());
        pedido.setTotal(datosNuevos.getTotal());
        pedido.setEstado(datosNuevos.getEstado());
        pedido.setFechaEntrega(datosNuevos.getFechaEntrega());
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}