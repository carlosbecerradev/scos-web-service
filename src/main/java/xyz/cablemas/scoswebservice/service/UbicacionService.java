package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Ubicacion;

public interface UbicacionService {

	void save(Ubicacion ubicacion);

	void delete(Ubicacion ubicacion);

	Collection<Ubicacion> findAll();

	Ubicacion findById(Long uicacionId);

}
