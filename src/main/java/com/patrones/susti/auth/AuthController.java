package com.patrones.susti.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class AuthController {

  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse>  login(LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.username(),
                    request.password()
            )
    );
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    String jwt = jwtService.generarToken(userDetails);
    return ResponseEntity.ok(new LoginResponse(jwt));
  }
}
