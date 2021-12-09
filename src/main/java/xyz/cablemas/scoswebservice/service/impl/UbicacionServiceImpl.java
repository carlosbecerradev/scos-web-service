package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Ubicacion;
import xyz.cablemas.scoswebservice.repository.UbicacionRepository;
import xyz.cablemas.scoswebservice.service.UbicacionService;

@Service
@AllArgsConstructor
public class UbicacionServiceImpl implements UbicacionService {
	
	private final UbicacionRepository ubicacionRepository; 

	@Override
	@Transactional
	public void save(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}

	@Override
	@Transactional
	public void delete(Ubicacion ubicacion) {
		ubicacionRepository.delete(ubicacion);		
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Ubicacion> findAll() {
		return ubicacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ubicacion findById(Long uicacionId) {
		return ubicacionRepository.findById(uicacionId).orElse(null);
	}

}
