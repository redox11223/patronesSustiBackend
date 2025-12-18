package com.patrones.susti.precios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerEstrategiaService {

  private final PrecioDescuento precioDescuento;
  private final PrecioEstandar precioEstandar;
  private final PrecioDinamico precioDinamico;

  public PrecioEstrategia obtenerPrecioEstrategia(String estrategia){
    return switch (estrategia){
      case "DINAMICO"->precioDinamico;
      case "DESCUENTO"->precioDescuento;
      default -> precioEstandar;
    };
  }
}
