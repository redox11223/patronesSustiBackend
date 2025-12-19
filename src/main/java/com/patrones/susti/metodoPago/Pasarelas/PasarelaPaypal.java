package com.patrones.susti.metodoPago.Pasarelas;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasarelaPaypal implements PasarelaPago{

  private final PaypalService paypalService;

  @Override
  public boolean procesarPago(Double monto) {
    return paypalService.procesarPago(monto);
  }
}
