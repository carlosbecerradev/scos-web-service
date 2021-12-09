package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Cliente;
import xyz.cablemas.scoswebservice.repository.ClienteRepository;
import xyz.cablemas.scoswebservice.service.ClienteService;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	@Transactional
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long clienteId) {
		repository.deleteById(clienteId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long clienteId) {
		return repository.findById(clienteId).orElse(null);
	}

}
