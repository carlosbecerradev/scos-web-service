package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.TipodeIncidencia;



public interface TipodeIncidenciaService {

	
	public abstract void insert(TipodeIncidencia tipodeincidencia);
	public abstract void update(TipodeIncidencia tipodeincidencia);
	public abstract void delete(Long tipodeincidenciaId);
	public abstract TipodeIncidencia findById(Long tipodeincidenciaId);
	public abstract Collection<TipodeIncidencia> findAll();
}
