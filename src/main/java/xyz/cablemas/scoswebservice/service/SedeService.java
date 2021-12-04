package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Sede;

public interface SedeService {
	
	public abstract void insert(Sede sede);
	public abstract void update(Sede sede);
	public abstract void delete(Long sedeId);
	public abstract Sede findById(Long sedeId);
	public abstract Collection<Sede> findAll();

}
