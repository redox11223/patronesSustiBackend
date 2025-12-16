package com.patrones.susti.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String nombre;
  String constrasena;
  boolean activo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rol_id",nullable = false)
  Rol roles;
}
