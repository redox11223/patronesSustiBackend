package com.patrones.susti.Pago;

import com.patrones.susti.Pago.Pasarelas.PasarelaPago;
import com.patrones.susti.pedidoSimple.EstadoPedido;
import com.patrones.susti.pedidoSimple.Pedido;
import com.patrones.susti.pedidoSimple.PedidoRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

  private final PagoRepo pagoRepo;
  private final ObtenerPasarelaService obtenerPasarelaService;
  private final PedidoRepo pedidoRepo;

  @Transactional
  @Override
  public Pago procesarPago(Pago pago) {
    PasarelaPago pasarelaPago = obtenerPasarelaService.obtenerPasarela(pago.getMetodoPago());
    Pedido pedido = pedidoRepo.findById(pago.getPedido().getId()).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    if (!pedido.getEstado().equals(EstadoPedido.PENDIENTE)) {
      throw new IllegalArgumentException("Solo se pueden pagar pedidos en estado PENDIENTE");
    }
    boolean exito = pasarelaPago.procesarPago(pedido.getMontoFinal());
    if (!exito) {
      throw new IllegalArgumentException("Pago no pudo ser procesado");
    }
    pedido.setEstado(EstadoPedido.PAGADO);
    pedidoRepo.save(pedido);

    pago.setMonto(pedido.getMontoFinal());
    pago.setActivo(false);

    return pagoRepo.save(pago);
  }
}
