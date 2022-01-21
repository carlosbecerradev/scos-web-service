package xyz.cablemas.scoswebservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.cablemas.scoswebservice.dto.ReporteTecnicoPorOrdenDeServicio;
import xyz.cablemas.scoswebservice.repository.OrdenDeServicioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/reporte")
public class ReportesController {

	@Autowired
	private OrdenDeServicioRepository ordenDeServicioRepository;

	@GetMapping("/tecnicos/sede/{nombre}")
	private ResponseEntity<Collection<ReporteTecnicoPorOrdenDeServicio>> getReporteDeTecnicosPorOrden(
			@PathVariable("nombre") String nombre) {
		return new ResponseEntity<Collection<ReporteTecnicoPorOrdenDeServicio>>(
				ordenDeServicioRepository.reporteTecnicos(nombre), HttpStatus.OK);
	}

}
