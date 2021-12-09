package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Sede;
import xyz.cablemas.scoswebservice.repository.SedeRepository;
import xyz.cablemas.scoswebservice.service.SedeService;

@Repository
@AllArgsConstructor
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRepository repository;

	@Override
	@Transactional
	public void insert(Sede sede) {
		repository.save(sede);
	}

	@Override
	@Transactional
	public void update(Sede sede) {
		repository.save(sede);
	}

	@Override
	@Transactional
	public void delete(Long sedeId) {
		repository.deleteById(sedeId);
	}

	@Override
	@Transactional(readOnly = true)
	public Sede findById(Long sedeId) {
		return repository.findById(sedeId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Sede> findAll() {
		return repository.findAll();
	}

}
