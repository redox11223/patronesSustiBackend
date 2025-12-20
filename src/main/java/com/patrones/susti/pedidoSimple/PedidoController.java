package com.patrones.susti.pedidoSimple;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

  private final PedidoService pedidoService;

  @PostMapping
  public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
    Pedido nuevoPedido = pedidoService.crearPedido(pedido);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
  }

  @GetMapping
  public ResponseEntity<Pedido> obtenerPedidoEjemplo() {
    Pedido pedidoEjemplo = pedidoService.obtenerPedidoPorId(1L);
    return ResponseEntity.ok(pedidoEjemplo);
  }

  @PutMapping("/{id}/cancelar")
  public ResponseEntity<Void> cancelarPedido(@PathVariable Long id) {
    pedidoService.cancelarPedido(id);
    return ResponseEntity.noContent().build();
  }
}