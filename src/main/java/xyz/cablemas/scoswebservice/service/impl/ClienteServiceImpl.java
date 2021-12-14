package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.dto.ClienteDto;
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

	@Override
	public ClienteDto mapEntityToDto(Cliente cliente) {
		return ClienteDto.builder().id(cliente.getClienteId()).nombres(cliente.getNombres())
				.apellidos(cliente.getApellidos()).fechaDeNacimiento(cliente.getFechaDeNacimiento())
				.sexo(cliente.getSexo()).dni(cliente.getDni()).nroDeTelefonoMovil(cliente.getNroDeTelefonoMovil())
				.nroDeTelefonoFijo(cliente.getNroDeTelefonoFijo()).direccion(cliente.getDireccion())
				.usuarioId(cliente.getUsuario().getUsuarioId())
				.tokenDeNotificacion(cliente.getUsuario().getTokenDeNotificacion())
				.ubicacion(cliente.getUsuario().getUbicacion()).sede(cliente.getUsuario().getSede().getNombre())
				.tipoDeServicio(cliente.getTipoDeServicio().getNombre()).build();
	}

}
