package com.patrones.susti.pedidoSimple;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

  private final CalculoPrecioService montoService;

  @GetMapping
  public ResponseEntity<Pedido> obtenerPedidoEjemplo(){
    Pedido pedidoEjemplo=new Pedido();
    pedidoEjemplo.setId(1L);
    pedidoEjemplo.setMonto(100.0);
    pedidoEjemplo.setMontoFinal(montoService.calcularPrecio(100.0));
    return ResponseEntity.ok(pedidoEjemplo);
  }
}
