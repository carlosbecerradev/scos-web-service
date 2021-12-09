package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;
import xyz.cablemas.scoswebservice.repository.ConstanciaDeVisitaRepository;
import xyz.cablemas.scoswebservice.service.ConstanciaDeVisitaService;

@Service
@AllArgsConstructor
public class ConstanciaDeVisitaServiceImpl implements ConstanciaDeVisitaService {

	private final ConstanciaDeVisitaRepository constanciaDeVisitaRepository;

	@Override
	@Transactional
	public void save(ConstanciaDeVisita constanciaDeVisita) {
		constanciaDeVisitaRepository.save(constanciaDeVisita);
	}

	@Override
	@Transactional
	public void delete(ConstanciaDeVisita constanciaDeVisita) {
		constanciaDeVisitaRepository.delete(constanciaDeVisita);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ConstanciaDeVisita> findAll() {
		return constanciaDeVisitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ConstanciaDeVisita findById(Long constanciaDeVisitaId) {
		return constanciaDeVisitaRepository.findById(constanciaDeVisitaId).orElse(null);
	}

}
