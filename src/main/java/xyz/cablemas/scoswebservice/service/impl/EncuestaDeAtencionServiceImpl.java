package xyz.cablemas.scoswebservice.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;
import xyz.cablemas.scoswebservice.entity.Valoracion;
import xyz.cablemas.scoswebservice.repository.EncuestaDeAtencionRepository;
import xyz.cablemas.scoswebservice.service.EncuestaDeAtencionService;

@Service
@AllArgsConstructor
public class EncuestaDeAtencionServiceImpl implements EncuestaDeAtencionService {

	private final EncuestaDeAtencionRepository encuestaDeAtencionRepository;

	@Override
	@Transactional
	public void save(EncuestaDeAtencion encuestaDeAtencion) {
		encuestaDeAtencionRepository.save(encuestaDeAtencion);
	}

	@Override
	@Transactional
	public void delete(EncuestaDeAtencion encuestaDeAtencion) {
		encuestaDeAtencionRepository.delete(encuestaDeAtencion);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<EncuestaDeAtencion> findAll() {
		return encuestaDeAtencionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public EncuestaDeAtencion findById(Long encuestaDeAtencionId) {
		return encuestaDeAtencionRepository.findById(encuestaDeAtencionId).orElse(null);
	}

	@Override
	public Collection<String> findAssessments() {
		return Arrays.asList(Valoracion.values()).stream().map(v -> v.toString()).collect(Collectors.toList());
	}

}
