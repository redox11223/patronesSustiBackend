package com.patrones.susti.pedidoSimple;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Pedido, Long> {
}
