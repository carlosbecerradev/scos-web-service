package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.cablemas.scoswebservice.dto.EncuestaDeAtencionDto;
import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;
import xyz.cablemas.scoswebservice.service.EncuestaDeAtencionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/encuesta-de-atencion")
public class EncuestaDeAtencionController {

	@Autowired
	private EncuestaDeAtencionService encuestaDeAtencionService;

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody EncuestaDeAtencionDto encuestaDeAtencionDto) {
		encuestaDeAtencionDto.setId(null);
		encuestaDeAtencionService.insertDto(encuestaDeAtencionDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/orden-de-servicio/id/{id}")
	public ResponseEntity<EncuestaDeAtencionDto> obtenerUnoPorOrdenDeServicioId(@PathVariable(name = "id") Long id) {
		EncuestaDeAtencion encontrado = encuestaDeAtencionService.findByOrdenDeServicioId(id);
		if (encontrado != null) {
			return new ResponseEntity<>(encuestaDeAtencionService.mapEntityToDto(encontrado), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/valoraciones")
	public ResponseEntity<Collection<String>> obtenerValoraciones() {
		return new ResponseEntity<>(encuestaDeAtencionService.findAssessments(), HttpStatus.OK);
	}

}
