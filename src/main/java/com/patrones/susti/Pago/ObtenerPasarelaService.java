package com.patrones.susti.Pago;

import com.patrones.susti.Pago.Pasarelas.PasarelaPago;
import com.patrones.susti.Pago.Pasarelas.PasarelaPaypal;
import com.patrones.susti.Pago.Pasarelas.PasarelaPlin;
import com.patrones.susti.Pago.Pasarelas.PasarelaYape;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPasarelaService {

  private final PasarelaPaypal pasarelaPaypal;
  private final PasarelaYape pasarelaYape;
  private final PasarelaPlin pasarelaPlin;

  public PasarelaPago obtenerPasarela(String metodoPago) {
    return switch (metodoPago.toLowerCase()) {
      case "paypal" -> pasarelaPaypal;
      case "yape" -> pasarelaYape;
      case "plin" -> pasarelaPlin;
      default -> throw new IllegalArgumentException("Método de pago no soportado: " + metodoPago);
    };
  }
}
