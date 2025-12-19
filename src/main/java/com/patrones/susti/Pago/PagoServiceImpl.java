package com.patrones.susti.Pago;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

  private final PagoRepo pagoRepo;

  @Override
  public List<Pago> obtenerTodosLosMetodosPago() {
    return pagoRepo.findAll();
  }

  @Override
  public Pago crearMetodoPago(Pago pago) {
    if(pagoRepo.existsByNombre(pago.getTipo())){
      throw new RuntimeException("El metodo de pago ya existe");
    }
    return pagoRepo.save(pago);
  }

  @Override
  public Pago obtenerMetodoPagoPorId(Long id) {
    return pagoRepo.findById(id).orElseThrow(()->
            new RuntimeException("Metodo de pago no encontrado"));
  }

  @Override
  public Pago actualizarMetodoPago(Long id, Pago pago) {
    Pago pagoExistente = obtenerMetodoPagoPorId(id);
    pagoExistente.setTipo(pago.getTipo());
    return pagoRepo.save(pagoExistente);
  }
}
