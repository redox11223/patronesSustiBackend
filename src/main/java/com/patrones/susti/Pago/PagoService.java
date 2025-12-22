package com.patrones.susti.Pago;

import java.util.List;

public interface PagoService {
  Pago procesarPago(Pago pago);

  List<Pago> obtenerPagos();
}
