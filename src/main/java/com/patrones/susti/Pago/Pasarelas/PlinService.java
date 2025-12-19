package com.patrones.susti.Pago.Pasarelas;

import org.springframework.stereotype.Service;

@Service
public class PlinService {
  Double saldoDisponible = 1000.0;

  public boolean procesarPago(Double monto) {
    return saldoDisponible >= monto;
  }
}
