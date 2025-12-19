package com.patrones.susti.pedidoSimple;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cliente;

  @Enumerated(EnumType.STRING)
  private EstadoPedido estado = EstadoPedido.PENDIENTE;

  private Double monto;

  private Double montoFinal;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDate fechaCreacion;

}
