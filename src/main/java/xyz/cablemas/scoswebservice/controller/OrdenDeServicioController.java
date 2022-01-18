package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

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

import xyz.cablemas.scoswebservice.dto.OrdenDeServicioDto;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;
import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.security.AuthenticationService;
import xyz.cablemas.scoswebservice.service.EmpleadoService;
import xyz.cablemas.scoswebservice.service.OrdenDeServicioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/orden-de-servicio")
public class OrdenDeServicioController {

	@Autowired
	private OrdenDeServicioService ordenDeServicioService;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<Collection<OrdenDeServicioDto>> obtenerTodos() {
		Collection<OrdenDeServicioDto> ordenes = ordenDeServicioService.findAll().stream()
				.map(ordenDeServicioService::mapEntityToDto).collect(Collectors.toList());
		return new ResponseEntity<>(ordenes, HttpStatus.OK);
	}

	@GetMapping("/sede/{nombre}")
	public ResponseEntity<Collection<OrdenDeServicioDto>> obtenerTodasPorNombreDeSede(
			@PathVariable(name = "nombre") String nombre) {
		Collection<OrdenDeServicioDto> ordenes = ordenDeServicioService.findAllBySedeName(nombre).stream()
				.map(ordenDeServicioService::mapEntityToDto).collect(Collectors.toList());
		return new ResponseEntity<>(ordenes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdenDeServicioDto> obtenerUnoPorId(@PathVariable(name = "id") Long id) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			return new ResponseEntity<>(ordenDeServicioService.mapEntityToDto(encontrado), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody OrdenDeServicio ordenDeServicio) {
		ordenDeServicioService.create(ordenDeServicio);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable(name = "id") Long id) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			ordenDeServicioService.delete(encontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/estados")
	public ResponseEntity<Collection<String>> obtenerEstadosDeOrdenDeServicio() {
		return new ResponseEntity<>(ordenDeServicioService.findAllServiceOrdenStatus(), HttpStatus.OK);
	}

	@PutMapping("/asignar/{id}")
	public ResponseEntity<HttpStatus> asignada(@PathVariable(name = "id") Long id) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			Usuario usuario = authenticationService.getCurrentLoggedInUser();
			Empleado empleado = empleadoService.findByUsuario(usuario);
			ordenDeServicioService.assigned(encontrado, empleado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/resolver/{id}")
	public ResponseEntity<HttpStatus> resuelta(@PathVariable(name = "id") Long id) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			Usuario usuario = authenticationService.getCurrentLoggedInUser();
			Empleado empleado = empleadoService.findByUsuario(usuario);
			ordenDeServicioService.resolved(encontrado, empleado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/cancelar/{id}")
	public ResponseEntity<HttpStatus> cancelada(@PathVariable(name = "id") Long id,
			@PathParam(value = "motivoDeCancelacion") String motivoDeCancelacion) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			Usuario usuario = authenticationService.getCurrentLoggedInUser();
			Empleado empleado = empleadoService.findByUsuario(usuario);
			ordenDeServicioService.cancelled(encontrado, empleado, motivoDeCancelacion);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/cerrar/{id}")
	public ResponseEntity<HttpStatus> cerrada(@PathVariable(name = "id") Long id) {
		OrdenDeServicio encontrado = ordenDeServicioService.findById(id);
		if (encontrado != null) {
			ordenDeServicioService.closed(encontrado);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/revisar/{id}")
	public ResponseEntity<HttpStatus> revisada(@PathVariable(name = "id") Long id) {
		OrdenDeServicio ordenEncontrada = ordenDeServicioService.findById(id);
		if (ordenEncontrada != null) {
			ordenDeServicioService.checked(ordenEncontrada);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
