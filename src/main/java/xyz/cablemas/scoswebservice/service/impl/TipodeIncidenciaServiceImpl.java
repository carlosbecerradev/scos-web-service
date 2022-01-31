package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.cablemas.scoswebservice.entity.TipoDeIncidencia;
import xyz.cablemas.scoswebservice.repository.TipodeIncidenciaRepository;
import xyz.cablemas.scoswebservice.service.TipodeIncidenciaService;

@Repository
public class TipodeIncidenciaServiceImpl implements TipodeIncidenciaService {

	@Autowired
	private TipodeIncidenciaRepository repository;

	@Override
	@Transactional
	public void insert(TipoDeIncidencia tipodeincidencia) {
		repository.save(tipodeincidencia);
	}

	@Override
	@Transactional
	public void update(TipoDeIncidencia tipodeincidencia) {
		repository.save(tipodeincidencia);
	}

	@Override
	@Transactional
	public void delete(Long tipodeincidenciaId) {
		repository.deleteById(tipodeincidenciaId);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDeIncidencia findById(Long tipodeincidenciaId) {
		return repository.findById(tipodeincidenciaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoDeIncidencia> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Object findAllByTipoDeServicioId(Long tipoDeServicioId) {
		return repository.findByTipoDeServicioTipoDeServicioId(tipoDeServicioId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoDeIncidencia> findAllByTipoDeServicioName(String tipoDeServicioNombre) {
		return repository.findByTipoDeServicioNombre(tipoDeServicioNombre);
	}

}
