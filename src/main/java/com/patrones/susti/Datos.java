package com.patrones.susti;

import com.patrones.susti.pedidoSimple.Pedido;
import com.patrones.susti.pedidoSimple.PedidoRepo;
import com.patrones.susti.precios.precioConfig.EstrategiaPrecio;
import com.patrones.susti.precios.precioConfig.PrecioConfig;
import com.patrones.susti.precios.precioConfig.PrecioConfigRepo;
import com.patrones.susti.usuarios.Rol;
import com.patrones.susti.usuarios.RolRepo;
import com.patrones.susti.usuarios.Usuario;
import com.patrones.susti.usuarios.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Datos implements CommandLineRunner {

  private final UsuarioRepo usuarioRepo;
  private final RolRepo rolRepo;
  private final PasswordEncoder passwordEncoder;
  private final PrecioConfigRepo precioConfigRepo;
  private final PedidoRepo pedidoRepo;

  @Override
  public void run(String... args) throws Exception {
    if (rolRepo.count() == 0) {
      Rol adminRole = new Rol();
      adminRole.setNombre("ADMIN");
      rolRepo.save(adminRole);

      Rol userRole = new Rol();
      userRole.setNombre("USER");
      rolRepo.save(userRole);
    }

    if (usuarioRepo.count() == 0) {
      Rol adminRole = rolRepo.findByNombre("ADMIN")
              .orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));

      Usuario admin = new Usuario();
      admin.setNombre("admin");
      admin.setPassword(passwordEncoder.encode("admin123"));
      admin.setDni("12345678");
      admin.setActivo(true);
      admin.setRoles(adminRole);
      usuarioRepo.save(admin);

      System.out.println("Usuario admin creado (password: admin123)");
    }

    if (precioConfigRepo.count() == 0) {

      PrecioConfig estandar = new PrecioConfig();
      estandar.setEstrategia(EstrategiaPrecio.ESTANDAR);
      estandar.setDescuentoPorcentaje(0.0);
      estandar.setFactorDinamico(1.0);
      precioConfigRepo.save(estandar);
    }

    if (pedidoRepo.count() == 0) {
      Pedido pedido = new Pedido();
      pedido.setCliente("Miguel");
      pedido.setMonto(100.0);
      pedidoRepo.save(pedido);
    }

    System.out.println(" Datos iniciales cargados correctamente");
  }
}
