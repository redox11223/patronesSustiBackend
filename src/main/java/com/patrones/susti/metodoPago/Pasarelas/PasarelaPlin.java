package com.patrones.susti.metodoPago.Pasarelas;

public class PasarelaPlin implements PasarelaPago{
  @Override
  public boolean procesarPago(Double monto) {
    return false;
  }
}
