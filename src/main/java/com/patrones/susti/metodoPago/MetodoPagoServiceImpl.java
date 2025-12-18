package com.patrones.susti.metodoPago;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl implements MetodoPagoService{

  private final MetodoPagoRepo metodoPagoRepo;

  @Override
  public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
    return null;
  }

  @Override
  public MetodoPago obtenerMetodoPagoPorId(Long id) {
    return null;
  }

  @Override
  public MetodoPago actualizarMetodoPago(Long id, MetodoPago metodoPago) {
    return null;
  }
}
