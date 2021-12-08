package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.TipoDeServicio;



public interface TipodeServicioService {

	public abstract void insert(TipoDeServicio tipodeservicio);
	public abstract void update(TipoDeServicio tipodeservicio);
	public abstract void delete(Long tipodeservicioId);
	public abstract TipoDeServicio findById(Long tipodeservicioId);
	public abstract Collection<TipoDeServicio> findAll();
	
}
