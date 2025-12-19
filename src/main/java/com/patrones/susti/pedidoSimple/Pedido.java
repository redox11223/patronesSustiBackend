package com.patrones.susti.pedidoSimple;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String cliente;
  @Enumerated(EnumType.STRING)
  EstadoPedido estado=EstadoPedido.PENDIENTE;
  Double monto;
  Double montoFinal;
  LocalDate fechaCreacion;

}
