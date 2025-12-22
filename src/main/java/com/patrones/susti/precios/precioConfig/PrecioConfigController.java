package com.patrones.susti.precios.precioConfig;

import com.patrones.susti.pedidoSimple.EstadoPedido;
import com.patrones.susti.pedidoSimple.Pedido;
import com.patrones.susti.pedidoSimple.PedidoRepo;
import com.patrones.susti.precios.CalculoPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/precio")
public class PrecioConfigController {

  private final PrecioConfigService precioConfigService;
  private final PedidoRepo pedidoRepo;
  private final CalculoPrecioService precioService;

  @GetMapping
  public ResponseEntity<PrecioConfig> obtenerPrecioConfig() {
    PrecioConfig precioConfig = precioConfigService.obtenerPrecioConfig();
    return ResponseEntity.ok(precioConfig);
  }

  @PutMapping
  public ResponseEntity<PrecioConfig> actualizarPrecioConfig(@RequestBody PrecioConfig precioConfig) {
    PrecioConfig newPrecioConfig = precioConfigService.actualizarPrecioConfig(precioConfig);
    actualizarPedidosExistentes();
    return ResponseEntity.ok(newPrecioConfig);
  }

  private void actualizarPedidosExistentes() {
    List<Pedido> pedidos = pedidoRepo.findByEstado(EstadoPedido.PENDIENTE);
    pedidos.forEach(pedido -> {
      Double nuevoPrecio = precioService.calcularPrecio(pedido.getMonto());
      pedido.setMontoFinal(nuevoPrecio);
      pedidoRepo.save(pedido);
    });
  }
}
