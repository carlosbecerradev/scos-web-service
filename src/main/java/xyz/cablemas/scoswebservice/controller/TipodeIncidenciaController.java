package xyz.cablemas.scoswebservice.controller;

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

import xyz.cablemas.scoswebservice.entity.TipodeIncidencia;
import xyz.cablemas.scoswebservice.service.TipodeIncidenciaService;

@RestController
@RequestMapping("/v1/tipo-de-incidencia")
public class TipodeIncidenciaController {

	@Autowired
	private TipodeIncidenciaService tipodeincidenciaService;

	@GetMapping
	public ResponseEntity<?> obtenerTodos() {
		return new ResponseEntity<>(tipodeincidenciaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{tipodeincidenciaId}")
	public ResponseEntity<?> obtenerUnoPorId(@PathVariable Long tipodeincidenciaId) {
		TipodeIncidencia tipodeincidencia = tipodeincidenciaService.findById(tipodeincidenciaId);

		if (tipodeincidencia != null) {
			return new ResponseEntity<>(tipodeincidencia, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody TipodeIncidencia tipodeincidencia) {
		tipodeincidenciaService.insert(tipodeincidencia);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{tipodeincidenciaId}")
	public ResponseEntity<?> actualizar(@PathVariable Long tipodeincidenciaId,
			@RequestBody TipodeIncidencia tipodeincidencia) {
		TipodeIncidencia tipodeincidenciaDb = tipodeincidenciaService.findById(tipodeincidenciaId);

		if (tipodeincidenciaDb != null) {
			tipodeincidenciaDb.setNombre(tipodeincidencia.getNombre());
			tipodeincidenciaDb.setActivo(tipodeincidencia.getActivo());
			tipodeincidenciaDb.setFechaDeCreacion(tipodeincidencia.getFechaDeCreacion());

			tipodeincidenciaService.update(tipodeincidenciaDb);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{tipodeincidenciaId}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long tipodeincidenciaId) {
		TipodeIncidencia tipodeincidenciaDb = tipodeincidenciaService.findById(tipodeincidenciaId);

		if (tipodeincidenciaDb != null) {
			tipodeincidenciaService.delete(tipodeincidenciaId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
