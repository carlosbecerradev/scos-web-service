package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.dto.EncuestaDeAtencionDto;
import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;

public interface EncuestaDeAtencionService {

	void save(EncuestaDeAtencion encuestaDeAtencion);

	void delete(EncuestaDeAtencion encuestaDeAtencion);

	Collection<EncuestaDeAtencion> findAll();

	EncuestaDeAtencion findById(Long encuestaDeAtencionId);

	Collection<String> findAssessments();

	void insertDto(EncuestaDeAtencionDto encuestaDeAtencionDto);

	void omitted(Long ordenDeServicioId);

	EncuestaDeAtencionDto mapEntityToDto(EncuestaDeAtencion encuesta);

	EncuestaDeAtencion findByOrdenDeServicioId(Long ordenDeServicioId);

}
