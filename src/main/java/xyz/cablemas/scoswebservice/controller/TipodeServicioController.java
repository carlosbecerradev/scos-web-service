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

import xyz.cablemas.scoswebservice.entity.TipodeServicio;
import xyz.cablemas.scoswebservice.service.TipodeServicioService;

@RestController
@RequestMapping("/v1/tipodeservicio")
public class TipodeServicioController {

	@Autowired
	private TipodeServicioService tipodeservicioService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(tipodeservicioService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/buscar/{tipodeservicioId}")
	public ResponseEntity<?> buscar(@PathVariable Long tipodeservicioId) {
		TipodeServicio tipodeservicio = tipodeservicioService.findById(tipodeservicioId);

		if (tipodeservicio != null) {
			return new ResponseEntity<>(tipodeservicio, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody TipodeServicio tipodeservicio)
	{
		tipodeservicioService.insert(tipodeservicio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/editar/{tipodeservicioId}")
	public ResponseEntity<?> editar(@PathVariable Long tipodeservicioId,@RequestBody TipodeServicio tipodeservicio)
	{
		TipodeServicio tipodeservicioDb=tipodeservicioService.findById(tipodeservicioId);
		
		if(tipodeservicioDb!=null)
		{
			tipodeservicioDb.setNombre(tipodeservicio.getNombre());
			tipodeservicioDb.setActivo(tipodeservicio.getActivo());
			tipodeservicioDb.setFechaDeCreacion(tipodeservicio.getFechaDeCreacion());
			
			
			
			tipodeservicioService.update(tipodeservicioDb);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}
	
	
	
	@DeleteMapping("/borrar/{tipodeservicioId}")
	public ResponseEntity<?> borrar(@PathVariable Long tipodeservicioId)
	{
		TipodeServicio tipodeservicioDb=tipodeservicioService.findById(tipodeservicioId);
		
		if(tipodeservicioDb!=null) 
		{
			tipodeservicioService.delete(tipodeservicioId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}