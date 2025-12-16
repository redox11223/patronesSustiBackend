package com.patrones.susti.auth;

public record LoginRequest(
    String username,
    String password
) {
}
