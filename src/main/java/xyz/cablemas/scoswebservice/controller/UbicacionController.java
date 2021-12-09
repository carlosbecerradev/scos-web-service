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

import xyz.cablemas.scoswebservice.entity.Ubicacion;
import xyz.cablemas.scoswebservice.service.UbicacionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/ubicacion")
public class UbicacionController {

	@Autowired
	private UbicacionService ubicacionService;

	@GetMapping
	public ResponseEntity<Collection<Ubicacion>> obtenerTodos() {
		return new ResponseEntity<>(ubicacionService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ubicacion> obtenerUnoPorId(@PathVariable(name = "id") Long id) {
		Ubicacion encontrado = ubicacionService.findById(id);
		if (encontrado != null) {
			return new ResponseEntity<>(encontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody Ubicacion ubicacion) {
		ubicacionService.save(ubicacion);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody Ubicacion ubicacion, @PathVariable(name = "id") Long id) {
		Ubicacion encontrado = ubicacionService.findById(id);
		if (encontrado != null) {
			ubicacion.setUbicacionId(id);
			ubicacionService.save(ubicacion);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "id") Long id) {
		Ubicacion encontrado = ubicacionService.findById(id);
		if (encontrado != null) {
			ubicacionService.delete(encontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
