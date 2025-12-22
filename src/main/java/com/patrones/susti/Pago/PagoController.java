package com.patrones.susti.Pago;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping
  public ResponseEntity<List<Pago>> obtenerPagos() {
    List<Pago> pagos = pagoService.obtenerPagos();
    return ResponseEntity.ok(pagos);
  }
}
