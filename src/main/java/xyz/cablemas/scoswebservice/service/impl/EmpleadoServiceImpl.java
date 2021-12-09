package xyz.cablemas.scoswebservice.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.EstadoDeTecnico;
import xyz.cablemas.scoswebservice.repository.EmpleadoRepository;
import xyz.cablemas.scoswebservice.service.EmpleadoService;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepository;

	@Override
	@Transactional
	public void save(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	@Transactional
	public void deleteById(Long empleadoId) {
		empleadoRepository.deleteById(empleadoId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long empleadoId) {
		return empleadoRepository.findById(empleadoId).orElse(null);
	}

	@Override
	public Collection<String> findTechnicianStatus() {
		return Arrays.asList(EstadoDeTecnico.values()).stream().map(e -> e.toString()).collect(Collectors.toList());
	}

}
