package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;

public interface ConstanciaDeVisitaService {

	void save(ConstanciaDeVisita constanciaDeVisita);

	void delete(ConstanciaDeVisita constanciaDeVisita);

	Collection<ConstanciaDeVisita> findAll();

	ConstanciaDeVisita findById(Long constanciaDeVisitaId);

}
