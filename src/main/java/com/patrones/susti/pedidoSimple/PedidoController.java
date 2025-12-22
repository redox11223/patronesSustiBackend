package com.patrones.susti.pedidoSimple;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/{id}")
  public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id) {
    Pedido pedidoEjemplo = pedidoService.obtenerPedidoPorId(id);
    return ResponseEntity.ok(pedidoEjemplo);
  }

  @GetMapping
  public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
    List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
    return ResponseEntity.ok().body(pedidos);
  }

  @PutMapping("/{id}/cancelar")
  public ResponseEntity<Void> cancelarPedido(@PathVariable Long id) {
    pedidoService.cancelarPedido(id);
    return ResponseEntity.noContent().build();
  }
}