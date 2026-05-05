package com.tiendavideojuego.Carrito.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long juegoId;
    private String nombreJuego;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private LocalDateTime fechaAgregado;

    @PrePersist
    public void inicializar() {
        this.fechaAgregado = LocalDateTime.now();
        this.subtotal = this.cantidad * this.precioUnitario;
    }
}