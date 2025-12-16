package com.patrones.susti.usuarios.service;

import com.patrones.susti.usuarios.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepo usuarioRepo;
  private final RolRepo rolRepo;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Usuario crearUsuario(UsuarioDto usuario) {
    if(usuarioRepo.existsByDni(usuario.dni())){
      throw new RuntimeException("El usuario ya esta registrado");
    }
    Rol rol=rolRepo.findById(usuario.rolId()).orElseThrow(()->new RuntimeException("Rol no encontrado"));


    Usuario nuevoUsuario=new Usuario();
    nuevoUsuario.setNombre(usuario.nombre());
    nuevoUsuario.setDni(usuario.dni());
    nuevoUsuario.setPassword(passwordEncoder.encode(usuario.password()));
    nuevoUsuario.setRoles(rol);

    usuarioRepo.save(nuevoUsuario);

    return nuevoUsuario;
  }

}
