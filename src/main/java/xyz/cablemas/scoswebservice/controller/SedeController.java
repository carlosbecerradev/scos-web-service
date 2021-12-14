package xyz.cablemas.scoswebservice.controller;

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

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Sede;
import xyz.cablemas.scoswebservice.service.SedeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/sede")
@AllArgsConstructor
public class SedeController {

	private final SedeService sedeService;

	@GetMapping
	public ResponseEntity<?> obtenerTodos() {
		return new ResponseEntity<>(sedeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{sedeId}")
	public ResponseEntity<?> obtenerUnoPorId(@PathVariable Long sedeId) {
		Sede sede = sedeService.findById(sedeId);
		if (sede != null) {
			return new ResponseEntity<>(sede, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Sede sede) {
		sedeService.insert(sede);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{sedeId}")
	public ResponseEntity<?> actualizar(@PathVariable Long sedeId, @RequestBody Sede sede) {
		Sede sedeEncontrada = sedeService.findById(sedeId);
		if (sedeEncontrada != null) {
			sede.setSedeId(sedeId);
			sedeService.update(sede);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{sedeId}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long sedeId) {
		Sede sedeEncontrada = sedeService.findById(sedeId);
		if (sedeEncontrada != null) {
			sedeService.delete(sedeId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
