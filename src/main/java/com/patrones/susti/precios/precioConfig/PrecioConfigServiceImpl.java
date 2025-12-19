package com.patrones.susti.precios.precioConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrecioConfigServiceImpl implements PrecioConfigService {

  private final PrecioConfigRepo precioConfigRepo;

  @Override
  public PrecioConfig obtenerPrecioConfig() {
    return precioConfigRepo.findById(1L).orElseThrow(() ->
            new RuntimeException("No se encontró la configuración de precios"));
  }

  @Override
  public PrecioConfig actualizarPrecioConfig(PrecioConfig nuevaConfig) {

    PrecioConfig precioConfig = obtenerPrecioConfig();

    precioConfig.setEstrategia(nuevaConfig.getEstrategia());
    precioConfig.setFactorDinamico(nuevaConfig.getFactorDinamico());
    precioConfig.setDescuentoPorcentaje(nuevaConfig.getDescuentoPorcentaje());

    return precioConfigRepo.save(precioConfig);
  }
}
