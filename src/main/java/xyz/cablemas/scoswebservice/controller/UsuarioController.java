package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<Collection<Usuario>> obtenerTodos() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> obtenerUnoPorId(@PathVariable(name = "usuarioId") Long usuarioId) {
		Usuario usuarioEncontrado = usuarioService.findById(usuarioId);
		if (usuarioEncontrado != null) {
			return new ResponseEntity<Usuario>(usuarioEncontrado, HttpStatus.OK);
		}
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/{usuarioId}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody Usuario usuario,
			@PathVariable(name = "usuarioId") Long usuarioId) {
		Usuario usuarioEncontrado = usuarioService.findById(usuarioId);
		if (usuarioEncontrado != null) {
			usuario.setUsuarioId(usuarioId);
			usuarioService.save(usuario);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "usuarioId") Long usuarioId) {
		Usuario usuarioEncontrado = usuarioService.findById(usuarioId);
		if (usuarioEncontrado != null) {
			usuarioService.deleteById(usuarioId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
