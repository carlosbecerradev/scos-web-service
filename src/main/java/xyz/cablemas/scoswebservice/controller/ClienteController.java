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

import xyz.cablemas.scoswebservice.dto.ClienteDto;
import xyz.cablemas.scoswebservice.entity.Cliente;
import xyz.cablemas.scoswebservice.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Collection<Cliente>> obtenerTodos() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> obtenerUnoPorId(@PathVariable(name = "clienteId") Long clienteId) {
		Cliente clienteEncontrado = clienteService.findById(clienteId);
		if (clienteEncontrado != null) {
			return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody Cliente cliente,
			@PathVariable(name = "clienteId") Long clienteId) {
		Cliente clienteEncontrado = clienteService.findById(clienteId);
		if (clienteEncontrado != null) {
			cliente.setClienteId(clienteId);
			clienteService.save(cliente);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "clienteId") Long clienteId) {
		Cliente clienteEncontrado = clienteService.findById(clienteId);
		if (clienteEncontrado != null) {
			clienteService.deleteById(clienteId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/nombre-de-usuario/{nombreDeUsuario}")
	public ResponseEntity<ClienteDto> obtenerUnoPorNombreDeUsuarioo(
			@PathVariable(name = "nombreDeUsuario") String nombreDeUsuario) {
		ClienteDto clienteEncontrado = clienteService.findByUsername(nombreDeUsuario);
		if (clienteEncontrado != null) {
			return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
