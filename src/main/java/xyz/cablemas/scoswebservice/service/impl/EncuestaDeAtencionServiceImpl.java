package xyz.cablemas.scoswebservice.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.EncuestaDeAtencionDto;
import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;
import xyz.cablemas.scoswebservice.entity.Valoracion;
import xyz.cablemas.scoswebservice.repository.EncuestaDeAtencionRepository;
import xyz.cablemas.scoswebservice.service.EncuestaDeAtencionService;
import xyz.cablemas.scoswebservice.service.OrdenDeServicioService;

@Service
@AllArgsConstructor
public class EncuestaDeAtencionServiceImpl implements EncuestaDeAtencionService {

	private final EncuestaDeAtencionRepository encuestaDeAtencionRepository;
	private final OrdenDeServicioService ordenDeServicioService;

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

	@Override
	@Transactional
	public void insertDto(EncuestaDeAtencionDto encuestaDeAtencionDto) {
		OrdenDeServicio orden = ordenDeServicioService.findById(encuestaDeAtencionDto.getOrdenDeServicioId());
		EncuestaDeAtencion encuesta = new EncuestaDeAtencion();
		encuesta.setOrdenDeServicio(orden);
		encuesta.setValoracion(encuestaDeAtencionDto.getValoracion().toString());
		encuesta.setObservacion(encuestaDeAtencionDto.getObservacion());
		encuesta.setOmitida(false);
		save(encuesta);
		ordenDeServicioService.closed(orden);
	}

	@Override
	@Transactional
	public void omitted(Long ordenDeServicioId) {
		OrdenDeServicio orden = ordenDeServicioService.findById(ordenDeServicioId);
		EncuestaDeAtencion encuesta = new EncuestaDeAtencion();
		encuesta.setOrdenDeServicio(orden);
		encuesta.setValoracion(Valoracion.CONFORME.name());
		encuesta.setObservacion("Omitida");
		encuesta.setOmitida(true);
		save(encuesta);
		ordenDeServicioService.closed(orden);
	}

	@Override
	public EncuestaDeAtencionDto mapEntityToDto(EncuestaDeAtencion encuesta) {
		return EncuestaDeAtencionDto.builder().id(encuesta.getEncuestaDeAtencionId())
				.valoracion(Valoracion.valueOf(encuesta.getValoracion())).observacion(encuesta.getObservacion())
				.omitida(encuesta.getOmitida()).fechaDeCreacion(encuesta.getFechaDeCreacion())
				.ordenDeServicioId(encuesta.getOrdenDeServicio().getOrdenDeServicioId()).build();
	}

	@Override
	@Transactional(readOnly = true)
	public EncuestaDeAtencion findByOrdenDeServicioId(Long ordenDeServicioId) {
		return encuestaDeAtencionRepository.findByOrdenDeServicioOrdenDeServicioId(ordenDeServicioId).orElse(null);
	}

}
