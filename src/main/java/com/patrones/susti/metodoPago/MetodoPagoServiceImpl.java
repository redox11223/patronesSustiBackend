package com.patrones.susti.metodoPago;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl implements MetodoPagoService{

  private final MetodoPagoRepo metodoPagoRepo;

  @Override
  public List<MetodoPago> obtenerTodosLosMetodosPago() {
    return metodoPagoRepo.findAll();
  }

  @Override
  public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
    if(metodoPagoRepo.existsByNombre(metodoPago.getTipo())){
      throw new RuntimeException("El metodo de pago ya existe");
    }
    return metodoPagoRepo.save(metodoPago);
  }

  @Override
  public MetodoPago obtenerMetodoPagoPorId(Long id) {
    return metodoPagoRepo.findById(id).orElseThrow(()->
            new RuntimeException("Metodo de pago no encontrado"));
  }

  @Override
  public MetodoPago actualizarMetodoPago(Long id, MetodoPago metodoPago) {
    MetodoPago metodoPagoExistente = obtenerMetodoPagoPorId(id);
    metodoPagoExistente.setTipo(metodoPago.getTipo());
    return metodoPagoRepo.save(metodoPagoExistente);
  }
}
