package com.tiendavideojuego.Pedido.controller;

import com.tiendavideojuego.Pedido.model.Pedido;
import com.tiendavideojuego.Pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/historial/{usuarioId}")
    public List<Pedido> historial(@PathVariable Long usuarioId) {
        return pedidoService.historialPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Long id,
                             @RequestBody Pedido datosNuevos) {
        return pedidoService.actualizarPedido(id, datosNuevos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return "Pedido eliminado";
    }
}