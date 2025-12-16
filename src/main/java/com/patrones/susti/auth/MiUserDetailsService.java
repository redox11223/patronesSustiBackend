package com.patrones.susti.auth;

import com.patrones.susti.usuarios.Usuario;
import com.patrones.susti.usuarios.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiUserDetailsService implements UserDetailsService {

  private final UsuarioRepo usuarioRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario =usuarioRepo.findByNombre(username).orElseThrow(()->
        new UsernameNotFoundException("Usuario no encontrado: " + username));

    GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+ usuario.getRoles().getNombre());
    List<GrantedAuthority> authorities=List.of(authority);

    return new User(
        usuario.getNombre(),
        usuario.getPassword(),
        usuario.isActivo(),
        true,
        true,
        true,
        authorities
    );
  }
}
