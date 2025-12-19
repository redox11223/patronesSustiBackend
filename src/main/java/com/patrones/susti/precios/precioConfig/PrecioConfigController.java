package com.patrones.susti.precios.precioConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/precio")
public class PrecioConfigController {

  private final PrecioConfigService precioConfigService;

  @GetMapping
  public ResponseEntity<PrecioConfig> obtenerPrecioConfig() {
    PrecioConfig precioConfig = precioConfigService.obtenerPrecioConfig();
    return ResponseEntity.ok(precioConfig);
  }

  @PutMapping
  public ResponseEntity<PrecioConfig> actualizarPrecioConfig(@RequestBody PrecioConfig precioConfig) {
    PrecioConfig newPrecioConfig = precioConfigService.actualizarPrecioConfig(precioConfig);
    return ResponseEntity.ok(newPrecioConfig);
  }
}
