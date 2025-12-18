package com.patrones.susti.precios;

import org.springframework.stereotype.Component;

@Component
public class PrecioEstandar implements PrecioEstrategia{
  @Override
  public Double calcularPrecio(Double monto) {
    return monto;
  }
}
