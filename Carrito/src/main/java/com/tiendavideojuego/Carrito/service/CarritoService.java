package com.tiendavideojuego.Carrito.service;

import com.tiendavideojuego.Carrito.model.Carro;
import com.tiendavideojuego.Carrito.model.DetalleCarrito;
import com.tiendavideojuego.Carrito.repository.CarroRepository;
import com.tiendavideojuego.Carrito.repository.DetalleCarritoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarroRepository carritoRepository;

    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    public Carro crearCarrito(Carro carrito) {
        return carritoRepository.save(carrito);
    }

    public List<Carro> verCarrito(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    public DetalleCarrito agregarJuego(DetalleCarrito detalle) {
        detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());
        DetalleCarrito guardado = detalleCarritoRepository.save(detalle);

        Carro carrito = carritoRepository.findById(detalle.getCarrito().getId())
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        double total = detalleCarritoRepository.findByCarritoId(carrito.getId())
                .stream().mapToDouble(DetalleCarrito::getSubtotal).sum();
        carrito.setTotal(total);
        carritoRepository.save(carrito);

        return guardado;
    }

    public List<DetalleCarrito> verDetalles(Long carritoId) {
        return detalleCarritoRepository.findByCarritoId(carritoId);
    }

    public DetalleCarrito actualizarDetalle(Long id, DetalleCarrito datosNuevos) {
        DetalleCarrito detalle = detalleCarritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
        detalle.setCantidad(datosNuevos.getCantidad());
        detalle.setPrecioUnitario(datosNuevos.getPrecioUnitario());
        detalle.setSubtotal(datosNuevos.getCantidad() * datosNuevos.getPrecioUnitario());
        return detalleCarritoRepository.save(detalle);
    }

    public void eliminarJuego(Long id) {
        detalleCarritoRepository.deleteById(id);
    }

    //Esto es para poder pagar, se usa .stream para que se hagan operaciones matemáticas, y que el programa pueda procesarlas.
    //.mapToDouble se usa para transformar valores a double para poder procesarlos mejor y hacer operaciones matemáticas básicas
    public Double totalAPagar(Long carritoId) {
        return detalleCarritoRepository.findByCarritoId(carritoId)
                .stream().mapToDouble(DetalleCarrito::getSubtotal).sum();
    }
}