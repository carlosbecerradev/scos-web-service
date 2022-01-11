package xyz.cablemas.scoswebservice.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.OrdenDeServicioDto;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.EstadoDeOrdenDeServicio;
import xyz.cablemas.scoswebservice.entity.EstadoDeTecnico;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;
import xyz.cablemas.scoswebservice.repository.OrdenDeServicioRepository;
import xyz.cablemas.scoswebservice.service.ClienteService;
import xyz.cablemas.scoswebservice.service.EmpleadoService;
import xyz.cablemas.scoswebservice.service.OrdenDeServicioService;

@Service
@AllArgsConstructor
public class OrdenDeServicioServiceImpl implements OrdenDeServicioService {

	private final OrdenDeServicioRepository ordenDeServicioRepository;
	private final EmpleadoService empleadoService;
	private final ClienteService clienteService;

	@Override
	@Transactional
	public void save(OrdenDeServicio ordenDeServicio) {
		ordenDeServicioRepository.save(ordenDeServicio);
	}

	@Override
	@Transactional
	public void delete(OrdenDeServicio ordenDeServicioId) {
		ordenDeServicioRepository.delete(ordenDeServicioId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<OrdenDeServicio> findAll() {
		return ordenDeServicioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public OrdenDeServicio findById(Long ordenDeServicioId) {
		return ordenDeServicioRepository.findById(ordenDeServicioId).orElse(null);
	}

	@Override
	public Collection<String> findAllServiceOrdenStatus() {
		return Arrays.asList(EstadoDeOrdenDeServicio.values()).stream().map(e -> e.toString())
				.collect(Collectors.toList());
	}

	@Override
	public OrdenDeServicioDto mapEntityToDto(OrdenDeServicio ordenDeServicio) {
		return OrdenDeServicioDto.builder().id(ordenDeServicio.getOrdenDeServicioId())
				.tipoDeIncidencia(ordenDeServicio.getTipoDeIncidencia().getNombre())
				.descripcionDelProblema(ordenDeServicio.getDescripcionDelProblema())
				.imagenUrl(ordenDeServicio.getImagenUrl())
				.cliente(clienteService.mapEntityToDto(ordenDeServicio.getCliente()))
				.empleado(empleadoService.mapEntityToDto(ordenDeServicio.getEmpleado()))
				.estado(ordenDeServicio.getEstado()).fechaDeCreacion(ordenDeServicio.getFechaDeCreacion())
				.fechaDeAsignacion(ordenDeServicio.getFechaDeAsignacion())
				.fechaDeLlegada(ordenDeServicio.getFechaDeLlegada())
				.fechaDeResolucion(ordenDeServicio.getFechaDeResolucion())
				.fechaDeCancelacion(ordenDeServicio.getFechaDeCancelacion())
				.fechaDeCierre(ordenDeServicio.getFechaDeCierre())
				.motivoDeCancelacion(ordenDeServicio.getMotivoDeCancelacion()).revisada(ordenDeServicio.isRevisada())
				.build();
	}

	@Override
	@Transactional
	public void create(OrdenDeServicio ordenDeServicio) {
		ordenDeServicio.setOrdenDeServicioId(null);
		ordenDeServicio.setEstado(EstadoDeOrdenDeServicio.CREADA.name());
		ordenDeServicio.setRevisada(false);
		ordenDeServicio.setMotivoDeCancelacion(null);
		ordenDeServicio.setFechaDeAsignacion(null);
		ordenDeServicio.setFechaDeLlegada(null);
		ordenDeServicio.setFechaDeResolucion(null);
		ordenDeServicio.setFechaDeCancelacion(null);
		ordenDeServicio.setFechaDeCierre(null);
		save(ordenDeServicio);
	}

	@Override
	@Transactional
	public void assigned(OrdenDeServicio ordenDeServicio, Empleado empleado) {
		if (empleado != null) {
			empleado.setEstado(EstadoDeTecnico.ASIGNADO.name());
			empleadoService.save(empleado);
			ordenDeServicio.setEmpleado(empleado);
			ordenDeServicio.setEstado(EstadoDeOrdenDeServicio.ASIGNADA.name());
			ordenDeServicio.setFechaDeAsignacion(LocalDateTime.now());
			save(ordenDeServicio);
		}
	}

	@Override
	@Transactional
	public void resolved(OrdenDeServicio ordenDeServicio, Empleado empleado) {
		if (empleado != null) {
			empleado.setEstado(EstadoDeTecnico.DISPONIBLE.name());
			empleadoService.save(empleado);
			ordenDeServicio.setEmpleado(empleado);
			ordenDeServicio.setEstado(EstadoDeOrdenDeServicio.RESUELTA.name());
			ordenDeServicio.setFechaDeResolucion(LocalDateTime.now());
			save(ordenDeServicio);
		}
	}

	@Override
	@Transactional
	public void cancelled(OrdenDeServicio ordenDeServicio, Empleado empleado, String motivoDeCancelacion) {
		if (empleado != null) {
			empleado.setEstado(EstadoDeTecnico.DISPONIBLE.name());
			empleadoService.save(empleado);
			ordenDeServicio.setEmpleado(empleado);
			ordenDeServicio.setMotivoDeCancelacion(motivoDeCancelacion);
			ordenDeServicio.setEstado(EstadoDeOrdenDeServicio.CANCELADA.name());
			ordenDeServicio.setFechaDeCancelacion(LocalDateTime.now());
			save(ordenDeServicio);
		}
	}

	@Override
	@Transactional
	public void closed(OrdenDeServicio ordenDeServicio) {
		ordenDeServicio.setEstado(EstadoDeOrdenDeServicio.CERRADA.name());
		ordenDeServicio.setFechaDeCierre(LocalDateTime.now());
		save(ordenDeServicio);
	}

	@Override
	@Transactional
	public void checked(OrdenDeServicio ordenDeServicio) {
		ordenDeServicio.setRevisada(true);
		save(ordenDeServicio);
	}

}
