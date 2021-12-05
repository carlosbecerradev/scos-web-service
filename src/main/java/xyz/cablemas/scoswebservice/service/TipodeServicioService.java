package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.TipodeServicio;



public interface TipodeServicioService {

	public abstract void insert(TipodeServicio tipodeservicio);
	public abstract void update(TipodeServicio tipodeservicio);
	public abstract void delete(Long tipodeservicioId);
	public abstract TipodeServicio findById(Long tipodeservicioId);
	public abstract Collection<TipodeServicio> findAll();
	
}
