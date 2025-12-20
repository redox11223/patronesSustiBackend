package com.patrones.susti.Pago.Pasarelas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PasarelaPlin implements PasarelaPago {
  private final PlinService plinService;

  @Override
  public boolean procesarPago(Double monto) {
    return plinService.procesarPago(monto);
  }
}
