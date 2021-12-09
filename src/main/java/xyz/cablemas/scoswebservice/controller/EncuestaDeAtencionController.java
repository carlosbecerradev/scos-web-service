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

import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;
import xyz.cablemas.scoswebservice.service.EncuestaDeAtencionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/emcuesta-de-atencion")
public class EncuestaDeAtencionController {

	@Autowired
	private EncuestaDeAtencionService encuestaDeAtencionService;

	@GetMapping
	public ResponseEntity<Collection<EncuestaDeAtencion>> obtenerTodos() {
		return new ResponseEntity<>(encuestaDeAtencionService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EncuestaDeAtencion> obtenerUnoPorId(@PathVariable(name = "id") Long id) {
		EncuestaDeAtencion encontrado = encuestaDeAtencionService.findById(id);
		if (encontrado != null) {
			return new ResponseEntity<>(encontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody EncuestaDeAtencion encuestaDeAtencion) {
		encuestaDeAtencionService.save(encuestaDeAtencion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody EncuestaDeAtencion encuestaDeAtencion,
			@PathVariable(name = "id") Long id) {
		EncuestaDeAtencion encontrado = encuestaDeAtencionService.findById(id);
		if (encontrado != null) {
			encuestaDeAtencion.setEncuestaDeAtencionId(id);
			encuestaDeAtencionService.save(encuestaDeAtencion);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "id") Long id) {
		EncuestaDeAtencion encontrado = encuestaDeAtencionService.findById(id);
		if (encontrado != null) {
			encuestaDeAtencionService.delete(encontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/valoraciones")
	public ResponseEntity<Collection<String>> obtenerValoraciones() {
		return new ResponseEntity<>(encuestaDeAtencionService.findAssessments(), HttpStatus.OK);
	}

}
