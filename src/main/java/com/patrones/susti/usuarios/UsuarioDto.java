package com.patrones.susti.usuarios;

public record UsuarioDto(
    String nombre,
    String password,
    String dni,
    Long rolId
) {
}
