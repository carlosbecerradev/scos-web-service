package xyz.cablemas.scoswebservice.controller;

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
import xyz.cablemas.scoswebservice.entity.TipodeServicio;
import xyz.cablemas.scoswebservice.service.TipodeIncidenciaService;

@RestController
@RequestMapping("/v1/tipodeincidencia")
public class TipodeIncidenciaController {
	
	private TipodeIncidenciaService tipodeincidenciaService;

	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(tipodeincidenciaService.findAll(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/buscar/{tipodeincidenciaId}")
	public ResponseEntity<?> buscar(@PathVariable Long tipodeincidenciaId) {
		TipodeIncidencia tipodeincidencia = tipodeincidenciaService.findById(tipodeincidenciaId);

		if (tipodeincidencia != null) {
			return new ResponseEntity<>(tipodeincidencia, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}
	
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody TipodeIncidencia tipodeincidencia)
	{
		tipodeincidenciaService.insert(tipodeincidencia);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{tipodeincidenciaId}")
	public ResponseEntity<?> editar(@PathVariable Long tipodeincidenciaId,@RequestBody TipodeIncidencia tipodeincidencia)
	{
		TipodeIncidencia tipodeincidenciaDb=tipodeincidenciaService.findById(tipodeincidenciaId);
		
		if(tipodeincidenciaDb!=null)
		{
			tipodeincidenciaDb.setNombre(tipodeincidencia.getNombre());
			tipodeincidenciaDb.setActivo(tipodeincidencia.getActivo());
			tipodeincidenciaDb.setFechaDeCreacion(tipodeincidencia.getFechaDeCreacion());
			
			
			
			tipodeincidenciaService.update(tipodeincidenciaDb);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}
	
	
	@DeleteMapping("/borrar/{tipodeincidenciaId}")
	public ResponseEntity<?> borrar(@PathVariable Long tipodeincidenciaId)
	{
		TipodeIncidencia tipodeincidenciaDb=tipodeincidenciaService.findById(tipodeincidenciaId);
		
		if(tipodeincidenciaDb!=null) 
		{
			tipodeincidenciaService.delete(tipodeincidenciaId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	
}
