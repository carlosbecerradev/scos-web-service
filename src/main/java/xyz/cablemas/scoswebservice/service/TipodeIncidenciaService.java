package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.TipoDeIncidencia;



public interface TipodeIncidenciaService {

	
	public abstract void insert(TipoDeIncidencia tipodeincidencia);
	public abstract void update(TipoDeIncidencia tipodeincidencia);
	public abstract void delete(Long tipodeincidenciaId);
	public abstract TipoDeIncidencia findById(Long tipodeincidenciaId);
	public abstract Collection<TipoDeIncidencia> findAll();
	public abstract Object findAllByTipoDeServicioId(Long tipoDeServicioId);
}
