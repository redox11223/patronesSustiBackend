package com.patrones.susti.Pago;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pago")
@RequiredArgsConstructor
public class PagoController {
  private final PagoService pagoService;

  @PostMapping
  public ResponseEntity<Pago> procesarPago(@RequestBody Pago pago) {
    Pago nuevoPago = pagoService.procesarPago(pago);
    return ResponseEntity.ok(nuevoPago);
  }
}
