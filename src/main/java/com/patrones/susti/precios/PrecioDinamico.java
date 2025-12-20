package com.patrones.susti.precios;

import com.patrones.susti.precios.precioConfig.PrecioConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrecioDinamico implements PrecioEstrategia {

  private final PrecioConfigService precioConfig;

  @Override
  public Double calcularPrecio(Double monto) {
    return monto * precioConfig.obtenerPrecioConfig().getFactorDinamico();
  }
}
