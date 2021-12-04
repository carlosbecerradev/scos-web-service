package xyz.cablemas.scoswebservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Sede;
import xyz.cablemas.scoswebservice.service.SedeService;


@RestController
@RequestMapping("/v1/sede")
@AllArgsConstructor
public class SedeController {
	
	private final SedeService sedeService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(sedeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{sedeId}")
	public ResponseEntity<?> buscar(@PathVariable Long sedeId) 
	{
		Sede sede=sedeService.findById(sedeId);
		
		if(sede!=null) {
			return new ResponseEntity<>(sede,HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Sede sede)
	{
		sedeService.insert(sede);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

}
