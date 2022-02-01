package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.dto.EmpleadoDto;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.Usuario;

public interface EmpleadoService {

	void save(Empleado empleado);

	void deleteById(Long empleadoId);

	Collection<Empleado> findAll();

	Empleado findById(Long empleadoId);

	Collection<String> findTechnicianStatus();

	EmpleadoDto mapEntityToDto(Empleado empleado);

	Empleado findByUsuario(Usuario usuario);

	EmpleadoDto findByUsername(String username);
}
