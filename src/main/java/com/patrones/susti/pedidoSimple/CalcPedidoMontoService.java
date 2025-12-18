package com.patrones.susti.pedidoSimple;

import com.patrones.susti.precios.ObtenerEstrategiaService;
import com.patrones.susti.precios.PrecioConfigService;
import com.patrones.susti.precios.PrecioEstrategia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalcPedidoMontoService {

  private final ObtenerEstrategiaService estrategiaService;
  private final PrecioConfigService configService;

  public Double calcularPrecio(Double monto){
    String estrategia=configService.obtenerPrecioConfig().getEstrategia().name();
    PrecioEstrategia precioEstrategia=estrategiaService.obtenerPrecioEstrategia(estrategia);
     return precioEstrategia.calcularPrecio(monto);
  }
}
