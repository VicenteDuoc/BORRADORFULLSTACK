package com.tiendavideojuego.Pedido.model;

import jakarta.persistence.*;
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

    private Long    usuarioId;
    private String  producto;
    private Integer cantidad;
    private Double  total;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaPedido;
    private LocalDateTime fechaEntrega;

    @PrePersist
    public void inicializar(){
        this.fechaPedido = LocalDateTime.now();
        this.estado = Estado.PENDIENTE;

    }
}
