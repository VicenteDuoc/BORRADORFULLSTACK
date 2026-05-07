package com.tiendavideojuego.Carrito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "detalle_carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El juego es obligatorio")
    private Long juegoId;

    @NotBlank(message = "El nombre del juego es obligatorio")
    private String nombreJuego;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El precio es obligatorio")
    private Double precioUnitario;

    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonIgnore
    private Carro carrito;

    @PrePersist
    public void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }
}