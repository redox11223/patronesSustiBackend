package com.patrones.susti.Pago.Pasarelas;

import org.springframework.stereotype.Service;

@Service
public class PaypalService {
  Double saldoDisponible=500.0;

  boolean procesarPago(Double monto) {
    return saldoDisponible>=monto;
  }
}
