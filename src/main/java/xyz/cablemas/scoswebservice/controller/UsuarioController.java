package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<Collection<Usuario>> getUsuarios() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(name = "usuarioId") Long usuarioId) {
		return new ResponseEntity<Usuario>(usuarioService.findById(usuarioId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> insertUsuario(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/{usuarioId}")
	public ResponseEntity<HttpStatus> updateUsuario(@RequestBody Usuario usuario,
			@PathVariable(name = "usuarioId") Long usuarioId) {
		usuarioService.save(usuario);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteUsuarioById(@PathVariable(name = "usuarioId") Long usuarioId) {
		usuarioService.deleteById(usuarioId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
