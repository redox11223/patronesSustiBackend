package com.patrones.susti.metodoPago;

public interface MetodoPagoService {
  MetodoPago crearMetodoPago(MetodoPago metodoPago);
  MetodoPago obtenerMetodoPagoPorId(Long id);
  MetodoPago actualizarMetodoPago(Long id, MetodoPago metodoPago);
}
