package xyz.cablemas.scoswebservice.service.impl;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.ConstanciaDeVisitaDto;
import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;
import xyz.cablemas.scoswebservice.entity.EstadoDeOrdenDeServicio;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;
import xyz.cablemas.scoswebservice.repository.ConstanciaDeVisitaRepository;
import xyz.cablemas.scoswebservice.service.ConstanciaDeVisitaService;
import xyz.cablemas.scoswebservice.service.OrdenDeServicioService;

@Service
@AllArgsConstructor
public class ConstanciaDeVisitaServiceImpl implements ConstanciaDeVisitaService {

	private final ConstanciaDeVisitaRepository constanciaDeVisitaRepository;
	private final OrdenDeServicioService ordenDeServicioService;

	@Override
	@Transactional
	public void save(ConstanciaDeVisita constanciaDeVisita) {
		constanciaDeVisitaRepository.save(constanciaDeVisita);
	}

	@Override
	@Transactional
	public void delete(ConstanciaDeVisita constanciaDeVisita) {
		constanciaDeVisitaRepository.delete(constanciaDeVisita);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ConstanciaDeVisita> findAll() {
		return constanciaDeVisitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ConstanciaDeVisita findById(Long constanciaDeVisitaId) {
		return constanciaDeVisitaRepository.findById(constanciaDeVisitaId).orElse(null);
	}

	@Override
	@Transactional
	public void insertDto(ConstanciaDeVisitaDto constanciaDeVisitaDto) {
		OrdenDeServicio orden = ordenDeServicioService.findById(constanciaDeVisitaDto.getOrdenDeServicioId());
		if (orden != null) {
			orden.setEstado(EstadoDeOrdenDeServicio.VISITADA.name());
			orden.setFechaDeLlegada(LocalDateTime.now());
			ordenDeServicioService.save(orden);
			ConstanciaDeVisita constancia = new ConstanciaDeVisita();
			constancia.setImagenUrl(constanciaDeVisitaDto.getImagenUrl());
			constancia.setOrdenDeServicio(orden);
			save(constancia);
		}
	}

	@Override
	public ConstanciaDeVisitaDto mapEntityToDto(ConstanciaDeVisita constanciaDeVisita) {
		return ConstanciaDeVisitaDto.builder().id(constanciaDeVisita.getConstanciaDeVisitaId())
				.imagenUrl(constanciaDeVisita.getImagenUrl()).fechaDeCreacion(constanciaDeVisita.getFechaDeCreacion())
				.ordenDeServicioId(constanciaDeVisita.getOrdenDeServicio().getOrdenDeServicioId()).build();
	}

	@Override
	@Transactional(readOnly = true)
	public ConstanciaDeVisita findByOrdenDeServicioId(Long ordenDeServicioId) {
		return constanciaDeVisitaRepository.findByOrdenDeServicioOrdenDeServicioId(ordenDeServicioId).orElse(null);
	}

}
