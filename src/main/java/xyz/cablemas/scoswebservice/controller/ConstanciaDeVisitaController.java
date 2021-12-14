package xyz.cablemas.scoswebservice.controller;

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

import xyz.cablemas.scoswebservice.dto.ConstanciaDeVisitaDto;
import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;
import xyz.cablemas.scoswebservice.service.ConstanciaDeVisitaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/constancia-de-visita")
public class ConstanciaDeVisitaController {

	@Autowired
	private ConstanciaDeVisitaService constanciaDeVisitaService;

	@GetMapping("/orden-de-servicio/id/{id}")
	public ResponseEntity<ConstanciaDeVisitaDto> obtenerUnoPorOrdenDeServicioId(@PathVariable(name = "id") Long id) {
		ConstanciaDeVisita encontrado = constanciaDeVisitaService.findByOrdenDeServicioId(id);
		if (encontrado != null) {
			return new ResponseEntity<>(constanciaDeVisitaService.mapEntityToDto(encontrado), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> registrar(@RequestBody ConstanciaDeVisitaDto constanciaDeVisitaDto) {
		constanciaDeVisitaDto.setId(null);
		constanciaDeVisitaService.insertDto(constanciaDeVisitaDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
