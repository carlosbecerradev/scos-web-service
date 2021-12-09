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

import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.service.EmpleadoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<Collection<Empleado>> obtenerTodos() {
		return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{empleadoId}")
	public ResponseEntity<Empleado> obtenerUnoPorId(@PathVariable(name = "empleadoId") Long empleadoId) {
		Empleado empleadoEncontrado = empleadoService.findById(empleadoId);
		if (empleadoEncontrado != null) {
			return new ResponseEntity<>(empleadoEncontrado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody Empleado empleado) {
		empleadoService.save(empleado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{empleadoId}")
	public ResponseEntity<HttpStatus> actualizar(@RequestBody Empleado empleado,
			@PathVariable(name = "empleadoId") Long empleadoId) {
		Empleado empleadoEncontrado = empleadoService.findById(empleadoId);
		if (empleadoEncontrado != null) {
			empleado.setEmpleadoId(empleadoId);
			empleadoService.save(empleado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{empleadoId}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "empleadoId") Long empleadoId) {
		Empleado empleadoEncontrado = empleadoService.findById(empleadoId);
		if (empleadoEncontrado != null) {
			empleadoService.deleteById(empleadoId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/status")
	public ResponseEntity<Collection<String>> obtenerEstadosDelTecnico() {
		return new ResponseEntity<>(empleadoService.findTechnicianStatus(), HttpStatus.OK);
	}

}
