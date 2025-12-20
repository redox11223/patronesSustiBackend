package com.patrones.susti.Pago.Pasarelas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PasarelaPaypal implements PasarelaPago {
  private final PaypalService paypalService;

  @Override
  public boolean procesarPago(Double monto) {
    return paypalService.procesarPago(monto);
  }
}
