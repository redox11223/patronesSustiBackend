package com.patrones.susti.Pago;

import java.util.List;

public interface PagoService {
  List<Pago> obtenerTodosLosMetodosPago();
  Pago crearMetodoPago(Pago pago);
  Pago obtenerMetodoPagoPorId(Long id);
  Pago actualizarMetodoPago(Long id, Pago pago);
}
