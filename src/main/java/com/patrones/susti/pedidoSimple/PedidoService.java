package com.patrones.susti.pedidoSimple;

public interface PedidoService {
  Pedido crearPedido(Pedido pedido);

  void cancelarPedido(Long id);

  Pedido obtenerPedidoPorId(Long id);
}
