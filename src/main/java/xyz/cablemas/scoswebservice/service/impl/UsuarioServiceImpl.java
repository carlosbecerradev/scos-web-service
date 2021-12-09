package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.repository.UsuarioRepository;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

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

}
