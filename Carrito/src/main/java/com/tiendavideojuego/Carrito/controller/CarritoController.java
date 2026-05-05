package com.tiendavideojuego.Carrito.controller;

import com.tiendavideojuego.Carrito.model.Carro;
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
    public Carro agregar(@RequestBody Carro item) {
        return carritoService.agregarJuego(item);
    }

    @GetMapping("/{usuarioId}")
    public List<Carro> verCarrito(@PathVariable Long usuarioId) {
        return carritoService.verCarrito(usuarioId);
    }

    @GetMapping("/total/{usuarioId}")
    public Double totalAPagar(@PathVariable Long usuarioId) {
        return carritoService.totalAPagar(usuarioId);
    }

    @PutMapping("/{id}")
    public Carro actualizar(@PathVariable Long id,
                                  @RequestBody Carro datosNuevos) {
        return carritoService.actualizarItem(id, datosNuevos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        carritoService.eliminarJuego(id);
        return "Juego eliminado del carrito";
    }

    @DeleteMapping("/vaciar/{usuarioId}")
    public String vaciar(@PathVariable Long usuarioId) {
        carritoService.vaciarCarrito(usuarioId);
        return "Carrito vaciado";
    }
}