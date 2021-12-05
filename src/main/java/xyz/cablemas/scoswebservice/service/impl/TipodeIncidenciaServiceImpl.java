package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.cablemas.scoswebservice.entity.TipodeIncidencia;
import xyz.cablemas.scoswebservice.repository.TipodeIncidenciaRepository;
import xyz.cablemas.scoswebservice.service.TipodeIncidenciaService;

@Repository
public class TipodeIncidenciaServiceImpl implements TipodeIncidenciaService {

	@Autowired
	private TipodeIncidenciaRepository repository;
	
	@Override
	@Transactional
	public void insert(TipodeIncidencia tipodeincidencia) {
		repository.save(tipodeincidencia);
		
	}

	@Override
	@Transactional
	public void update(TipodeIncidencia tipodeincidencia) {
		repository.save(tipodeincidencia);
		
	}

	@Override
	@Transactional
	public void delete(Long tipodeincidenciaId) {
		repository.deleteById(tipodeincidenciaId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public TipodeIncidencia findById(Long tipodeincidenciaId) {
		
		return repository.findById(tipodeincidenciaId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<TipodeIncidencia> findAll() {
		
		return repository.findAll();
	}

}
