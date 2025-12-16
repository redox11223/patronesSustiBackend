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

  @Column(nullable = false)
  String nombre;

  @Column(unique = true,nullable = false)
  String dni;

  @Column(nullable = false)
  String password;

  boolean activo=true;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rol_id",nullable = false)
  Rol roles;
}
