package com.tiendavideojuego.Carrito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

import java.util.List;

@Entity
@Table(name = "carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    private Double total;
    private LocalDateTime fechaAgregado;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<DetalleCarrito> detalles;

    @PrePersist
    public void inicializar() {
        this.fechaAgregado = LocalDateTime.now();
        this.total = 0.0;
    }
}