package com.patrones.susti.metodoPago.Pasarelas;

public class PasarelaYape implements PasarelaPago{
  @Override
  public boolean procesarPago(Double monto) {
    return false;
  }
}
