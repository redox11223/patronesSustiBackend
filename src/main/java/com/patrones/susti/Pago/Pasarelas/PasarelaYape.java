package com.patrones.susti.Pago.Pasarelas;

public class PasarelaYape implements PasarelaPago{
  @Override
  public boolean procesarPago(Double monto) {
    return false;
  }
}
