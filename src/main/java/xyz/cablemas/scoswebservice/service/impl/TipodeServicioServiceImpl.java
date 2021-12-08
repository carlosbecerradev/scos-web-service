package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.TipoDeServicio;
import xyz.cablemas.scoswebservice.repository.SedeRepository;
import xyz.cablemas.scoswebservice.repository.TipodeServicioRepository;
import xyz.cablemas.scoswebservice.service.TipodeServicioService;

@Repository
public class TipodeServicioServiceImpl implements TipodeServicioService{


	@Autowired
	private TipodeServicioRepository repository;
	
	@Override
	@Transactional
	public void insert(TipoDeServicio tipodeservicio) {
		repository.save(tipodeservicio);
		
	}

	@Override
	@Transactional
	public void update(TipoDeServicio tipodeservicio) {
		repository.save(tipodeservicio);
		
	}

	@Override
	@Transactional
	public void delete(Long tipodeservicioId) {
		repository.deleteById(tipodeservicioId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDeServicio findById(Long tipodeservicioId) {
		
		return repository.findById(tipodeservicioId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<TipoDeServicio> findAll() {
		
		return repository.findAll();
	}

}
