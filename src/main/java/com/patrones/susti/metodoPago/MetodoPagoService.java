package com.patrones.susti.metodoPago;

import java.util.List;

public interface MetodoPagoService {
  List<MetodoPago> obtenerTodosLosMetodosPago();
  MetodoPago crearMetodoPago(MetodoPago metodoPago);
  MetodoPago obtenerMetodoPagoPorId(Long id);
  MetodoPago actualizarMetodoPago(Long id, MetodoPago metodoPago);
}
