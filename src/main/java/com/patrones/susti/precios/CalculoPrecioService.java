package com.patrones.susti.precios;

import com.patrones.susti.precios.precioConfig.PrecioConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculoPrecioService {

  private final ObtenerEstrategiaService estrategiaService;
  private final PrecioConfigService configService;

  public Double calcularPrecio(Double monto) {
    String estrategia = configService.obtenerPrecioConfig().getEstrategia().name();
    PrecioEstrategia precioEstrategia = estrategiaService.obtenerPrecioEstrategia(estrategia);
    return precioEstrategia.calcularPrecio(monto);
  }
}
