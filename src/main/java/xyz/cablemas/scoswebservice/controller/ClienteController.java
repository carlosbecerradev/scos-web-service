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

import xyz.cablemas.scoswebservice.entity.Cliente;
import xyz.cablemas.scoswebservice.service.ClienteService;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Collection<Cliente>> getAll() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> getOneById(@PathVariable(name = "clienteId") Long clienteId) {
		return new ResponseEntity<>(clienteService.findById(clienteId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> insert(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<HttpStatus> update(@RequestBody Cliente cliente,
			@PathVariable(name = "clienteId") Long clienteId) {
		clienteService.save(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable(name = "clienteId") Long clienteId) {
		clienteService.deleteById(clienteId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
