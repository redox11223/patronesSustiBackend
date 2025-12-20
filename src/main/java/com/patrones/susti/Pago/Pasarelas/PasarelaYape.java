package com.patrones.susti.Pago.Pasarelas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PasarelaYape implements PasarelaPago {
  private final YapeService yapeService;

  @Override
  public boolean procesarPago(Double monto) {
    return yapeService.procesarPago(monto);
  }
}
