package xyz.cablemas.scoswebservice.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.LoginRequest;
import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@Service
@AllArgsConstructor
public class AuthenticationService {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final UsuarioService usuarioService;

	public String validateAuthentication(LoginRequest loginRequest) {
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
			return jwtService.generateJWT(auth);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Authentication getCurrentAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public Usuario getCurrentLoggedInUser() {
		Authentication auth = getCurrentAuthentication();
		return usuarioService.findByNombreDeUsuario(auth.getName());
	}

}
