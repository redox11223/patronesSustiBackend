package com.patrones.susti.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
  boolean existsByDni(String dni);
  Optional<Usuario> findByNombre(String username);
}
