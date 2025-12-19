package com.patrones.susti.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column(unique = true, nullable = false)
  private String dni;

  @Column(nullable = false)
  private String password;

  boolean activo = true;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rol_id", nullable = false)
  private Rol roles;
}
