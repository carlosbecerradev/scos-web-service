package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Empleado;

public interface EmpleadoService {

	void save(Empleado empleado);

	void deleteById(Long empleadoId);

	Collection<Empleado> findAll();

	Empleado findById(Long empleadoId);

	Collection<String> findTechnicianStatus();

}
