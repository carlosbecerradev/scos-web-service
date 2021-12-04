package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuario")
@AllArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<Collection<Usuario>> getUsuarios() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
	}

}
