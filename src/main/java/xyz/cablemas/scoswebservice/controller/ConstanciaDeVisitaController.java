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

import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;
import xyz.cablemas.scoswebservice.service.ConstanciaDeVisitaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/constancia-de-visita")
public class ConstanciaDeVisitaController {

	@Autowired
	private ConstanciaDeVisitaService constanciaDeVisitaService;

	@GetMapping
	public ResponseEntity<Collection<ConstanciaDeVisita>> obtenerTodos() {
		return new ResponseEntity<>(constanciaDeVisitaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConstanciaDeVisita> obtenerUnoPorId(@PathVariable(name = "id") Long id) {
		ConstanciaDeVisita encontrado = constanciaDeVisitaService.findById(id);
		if (encontrado != null) {
			return new ResponseEntity<>(encontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody ConstanciaDeVisita constanciaDeVisita) {
		constanciaDeVisitaService.save(constanciaDeVisita);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody ConstanciaDeVisita constanciaDeVisita,
			@PathVariable(name = "id") Long id) {
		ConstanciaDeVisita encontrado = constanciaDeVisitaService.findById(id);
		if (encontrado != null) {
			constanciaDeVisita.setConstanciaDeVisitaId(id);
			constanciaDeVisitaService.save(constanciaDeVisita);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "id") Long id) {
		ConstanciaDeVisita encontrado = constanciaDeVisitaService.findById(id);
		if (encontrado != null) {
			constanciaDeVisitaService.delete(encontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
