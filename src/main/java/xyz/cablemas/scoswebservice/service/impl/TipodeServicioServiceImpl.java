package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.TipodeServicio;
import xyz.cablemas.scoswebservice.repository.SedeRepository;
import xyz.cablemas.scoswebservice.repository.TipodeServicioRepository;
import xyz.cablemas.scoswebservice.service.TipodeServicioService;

@Repository
public class TipodeServicioServiceImpl implements TipodeServicioService{


	@Autowired
	private TipodeServicioRepository repository;
	
	@Override
	@Transactional
	public void insert(TipodeServicio tipodeservicio) {
		repository.save(tipodeservicio);
		
	}

	@Override
	@Transactional
	public void update(TipodeServicio tipodeservicio) {
		repository.save(tipodeservicio);
		
	}

	@Override
	@Transactional
	public void delete(Long tipodeservicioId) {
		repository.deleteById(tipodeservicioId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public TipodeServicio findById(Long tipodeservicioId) {
		
		return repository.findById(tipodeservicioId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<TipodeServicio> findAll() {
		
		return repository.findAll();
	}

}
