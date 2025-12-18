package com.patrones.susti.usuarios;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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
