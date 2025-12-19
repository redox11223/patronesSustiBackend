package com.patrones.susti.pedidoSimple;

public interface PedidoService {
  Pedido crearPedido(Pedido pedido);

  Pedido obtenerPedidoPorId(Long id);
}
