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

import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.service.EmpleadoService;

@RestController
@RequestMapping("/v1/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<Collection<Empleado>> getEmpleados() {
		return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{empleadoId}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable(name = "empleadoId") Long empleadoId) {
		return new ResponseEntity<>(empleadoService.findById(empleadoId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> insertEmpleado(@RequestBody Empleado empleado) {
		empleadoService.save(empleado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{empleadoId}")
	public ResponseEntity<HttpStatus> updateEmpleado(@RequestBody Empleado empleado,
			@PathVariable(name = "empleadoId") Long empleadoId) {
		empleadoService.save(empleado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteEmpleadoById(@PathVariable(name = "empleadoId") Long empleadoId) {
		empleadoService.deleteById(empleadoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
