package com.patrones.susti.Pago;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepo extends JpaRepository<Pago,Long> {
  boolean existsByNombre(String nombre);
}
