package com.patrones.susti.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String nombre;
}
