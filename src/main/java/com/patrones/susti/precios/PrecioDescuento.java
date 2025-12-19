package com.patrones.susti.precios;

import com.patrones.susti.precios.precioConfig.PrecioConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrecioDescuento implements PrecioEstrategia {

  private final PrecioConfigService precioConfig;

  @Override
  public Double calcularPrecio(Double monto) {
    return monto * (1 - precioConfig.obtenerPrecioConfig().getDescuentoPorcentaje() / 100);
  }
}
