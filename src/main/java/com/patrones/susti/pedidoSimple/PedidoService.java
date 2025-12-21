package com.patrones.susti.pedidoSimple;

import java.util.List;

public interface PedidoService {
  Pedido crearPedido(Pedido pedido);

  List<Pedido> obtenerTodosLosPedidos();

  void cancelarPedido(Long id);

  Pedido obtenerPedidoPorId(Long id);
}
