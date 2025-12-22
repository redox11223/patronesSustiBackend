package com.patrones.susti.pedidoSimple;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepo extends JpaRepository<Pedido, Long> {
  List<Pedido> findByEstado(EstadoPedido estado);
}
