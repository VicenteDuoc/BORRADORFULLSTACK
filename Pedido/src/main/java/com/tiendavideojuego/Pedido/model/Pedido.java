package com.tiendavideojuego.Pedido.model;

import com.tiendavideojuego.Pedido.model.Estado;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El producto es obligatorio")
    private String producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El total es obligatorio")
    private Double total;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaPedido;
    private LocalDateTime fechaEntrega;

    @PrePersist
    public void inicializar() {
        this.fechaPedido = LocalDateTime.now();
        this.estado = Estado.PENDIENTE;
    }
}
