package com.tiendavideojuego.Carrito.service;

import com.tiendavideojuego.Carrito.model.Carro;
import com.tiendavideojuego.Carrito.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public Carro agregarJuego(Carro item) {
        item.setSubtotal(item.getCantidad() * item.getPrecioUnitario());
        return carritoRepository.save(item);
    }

    public List<Carro> verCarrito(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    public Double totalAPagar(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId)
                .stream()
                .mapToDouble(Carro::getSubtotal)
                .sum();
    }

    public Carro actualizarItem(Long id, Carro datosNuevos) {
        Carro item = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));
        item.setCantidad(datosNuevos.getCantidad());
        item.setPrecioUnitario(datosNuevos.getPrecioUnitario());
        item.setSubtotal(datosNuevos.getCantidad() * datosNuevos.getPrecioUnitario());
        return carritoRepository.save(item);
    }

    public void eliminarJuego(Long id) {
        carritoRepository.deleteById(id);
    }

    public void vaciarCarrito(Long usuarioId) {
        carritoRepository.deleteByUsuarioId(usuarioId);
    }
}