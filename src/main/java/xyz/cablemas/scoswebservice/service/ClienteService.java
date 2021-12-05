package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Cliente;

public interface ClienteService {
	
	void save(Cliente cliente);

	void deleteById(Long clienteId);

	Collection<Cliente> findAll();

	Cliente findById(Long clienteId);


}
