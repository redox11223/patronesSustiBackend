package com.patrones.susti.auth.dto;

public record LoginRequest(
    String username,
    String password
) {
}
