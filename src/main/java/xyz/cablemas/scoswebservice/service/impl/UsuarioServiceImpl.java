package xyz.cablemas.scoswebservice.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.repository.UsuarioRepository;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByNombreDeUsuario(String nombreDeUsuario) {
		return usuarioRepository.findByNombreDeUsuario(nombreDeUsuario).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = findByNombreDeUsuario(username);
		if (usuario != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(usuario.getRol().name()));
			return new User(usuario.getNombreDeUsuario(), usuario.getContrasenia(), usuario.getActivo(), true, true,
					true, authorities);
		}
		throw new UsernameNotFoundException(username + " no existe");
	}

}
