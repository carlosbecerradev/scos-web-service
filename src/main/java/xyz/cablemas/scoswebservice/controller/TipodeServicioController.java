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

import xyz.cablemas.scoswebservice.entity.TipoDeServicio;
import xyz.cablemas.scoswebservice.service.TipodeServicioService;

@RestController
@RequestMapping("/v1/tipo-de-servicio")
public class TipodeServicioController {

	@Autowired
	private TipodeServicioService tipodeservicioService;

	@GetMapping
	public ResponseEntity<?> obtenerTodos() {
		return new ResponseEntity<>(tipodeservicioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{tipodeservicioId}")
	public ResponseEntity<?> obtenerUnoPorId(@PathVariable Long tipodeservicioId) {
		TipoDeServicio tipodeservicio = tipodeservicioService.findById(tipodeservicioId);

		if (tipodeservicio != null) {
			return new ResponseEntity<>(tipodeservicio, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody TipoDeServicio tipodeservicio) {
		tipodeservicioService.insert(tipodeservicio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{tipodeservicioId}")
	public ResponseEntity<?> actualizar(@PathVariable Long tipodeservicioId,
			@RequestBody TipoDeServicio tipodeservicio) {
		TipoDeServicio tipodeservicioDb = tipodeservicioService.findById(tipodeservicioId);

		if (tipodeservicioDb != null) {
			tipodeservicioDb.setNombre(tipodeservicio.getNombre());
			tipodeservicioDb.setActivo(tipodeservicio.getActivo());
			tipodeservicioDb.setFechaDeCreacion(tipodeservicio.getFechaDeCreacion());

			tipodeservicioService.update(tipodeservicioDb);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{tipodeservicioId}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Long tipodeservicioId) {
		TipoDeServicio tipodeservicioDb = tipodeservicioService.findById(tipodeservicioId);

		if (tipodeservicioDb != null) {
			tipodeservicioService.delete(tipodeservicioId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}