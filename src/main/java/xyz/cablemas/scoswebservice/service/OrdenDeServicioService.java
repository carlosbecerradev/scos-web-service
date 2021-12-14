package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.dto.OrdenDeServicioDto;
import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;

public interface OrdenDeServicioService {

	void save(OrdenDeServicio ordenDeServicio);

	void delete(OrdenDeServicio ordenDeServicioId);

	Collection<OrdenDeServicio> findAll();

	OrdenDeServicio findById(Long ordenDeServicioId);

	Collection<String> findAllServiceOrdenStatus();

	OrdenDeServicioDto mapEntityToDto(OrdenDeServicio ordenDeServicio);

	void create(OrdenDeServicio ordenDeServicio);

	void assigned(OrdenDeServicio ordenDeServicio, Empleado empleado);

	void resolved(OrdenDeServicio ordenDeServicio, Empleado empleado);

	void cancelled(OrdenDeServicio ordenDeServicio, Empleado empleado, String motivoDeCancelacion);

	void closed(OrdenDeServicio ordenDeServicio);

}