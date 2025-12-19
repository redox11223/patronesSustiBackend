package com.patrones.susti.Pago.Pasarelas;

import org.springframework.stereotype.Service;

@Service
public class YapeService {
  Double saldoDisponible = 500.0;

  public boolean procesarPago(Double monto) {
    return saldoDisponible >= monto;
  }
}
