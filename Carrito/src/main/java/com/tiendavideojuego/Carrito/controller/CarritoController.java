package com.tiendavideojuego.Carrito.controller;

import com.tiendavideojuego.Carrito.model.Carro;
import com.tiendavideojuego.Carrito.model.DetalleCarrito;
import com.tiendavideojuego.Carrito.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping
    public Carro crearCarrito(@RequestBody Carro carrito) {
        return carritoService.crearCarrito(carrito);
    }

    @GetMapping("/{usuarioId}")
    public List<Carro> verCarrito(@PathVariable Long usuarioId) {
        return carritoService.verCarrito(usuarioId);
    }

    @PostMapping("/detalle")
    public DetalleCarrito agregarJuego(@RequestBody DetalleCarrito detalle) {
        return carritoService.agregarJuego(detalle);
    }

    @GetMapping("/detalle/{carritoId}")
    public List<DetalleCarrito> verDetalles(@PathVariable Long carritoId) {
        return carritoService.verDetalles(carritoId);
    }

    @GetMapping("/total/{carritoId}")
    public Double totalAPagar(@PathVariable Long carritoId) {
        return carritoService.totalAPagar(carritoId);
    }

    @PutMapping("/detalle/{id}")
    public DetalleCarrito actualizar(@PathVariable Long id,
                                     @RequestBody DetalleCarrito datosNuevos) {
        return carritoService.actualizarDetalle(id, datosNuevos);
    }

    @DeleteMapping("/detalle/{id}")
    public String eliminar(@PathVariable Long id) {
        carritoService.eliminarJuego(id);
        return "Juego eliminado del carrito";
    }
}