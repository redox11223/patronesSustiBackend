package com.patrones.susti.pedidoSimple;

import com.patrones.susti.precios.CalculoPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
  private final PedidoRepo pedidoRepo;
  private final CalculoPrecioService calculoPrecioService;

  @Override
  public Pedido crearPedido(Pedido pedido) {
    pedido.setEstado(EstadoPedido.PENDIENTE);
    pedido.setMontoFinal(calculoPrecioService.calcularPrecio(pedido.getMonto()));
    return pedidoRepo.save(pedido);
  }

  @Override
  public List<Pedido> obtenerTodosLosPedidos() {
    return pedidoRepo.findAll();
  }

  @Override
  public void cancelarPedido(Long id) {
    Pedido pedido = obtenerPedidoPorId(id);
    pedido.setEstado(EstadoPedido.CANCELADO);
    pedidoRepo.save(pedido);
  }

  @Override
  public Pedido obtenerPedidoPorId(Long id) {
    return pedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
  }


}
