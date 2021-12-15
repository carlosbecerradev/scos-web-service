package xyz.cablemas.scoswebservice.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.EmpleadoDto;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.EstadoDeTecnico;
import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.repository.EmpleadoRepository;
import xyz.cablemas.scoswebservice.service.EmpleadoService;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void save(Empleado empleado) {
		String contrasenia = empleado.getUsuario().getContrasenia();
		if (contrasenia.length() < 60) {
			empleado.getUsuario().setContrasenia(passwordEncoder.encode(contrasenia));
		}
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

	@Override
	public EmpleadoDto mapEntityToDto(Empleado empleado) {
		return EmpleadoDto.builder().id(empleado.getEmpleadoId()).nombres(empleado.getNombres())
				.apellidos(empleado.getApellidos()).fotoUrl(empleado.getFotoUrl())
				.nroDeCarnet(empleado.getNroDeCarnet()).dni(empleado.getDni())
				.nroDeTelefonoMovil(empleado.getNroDeTelefonoMovil()).sexo(empleado.getSexo())
				.estado(empleado.getEstado()).usuarioId(empleado.getUsuario().getUsuarioId())
				.tokenDeNotificacion(empleado.getUsuario().getTokenDeNotificacion())
				.ubicacion(empleado.getUsuario().getUbicacion()).sede(empleado.getUsuario().getSede().getNombre())
				.build();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findByUsuario(Usuario usuario) {
		return empleadoRepository.findByUsuario(usuario).orElse(null);
	}

}
