package com.patrones.susti.precios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrecioConfig {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private EstrategiaPrecio estrategia = EstrategiaPrecio.ESTANDAR;

  private Double descuentoPorcentaje=0.0;
  private Double factorDinamico=1.0;
}
