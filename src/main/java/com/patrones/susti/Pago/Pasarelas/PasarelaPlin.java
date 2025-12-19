package com.patrones.susti.Pago.Pasarelas;

public class PasarelaPlin implements PasarelaPago{
  @Override
  public boolean procesarPago(Double monto) {
    return false;
  }
}
