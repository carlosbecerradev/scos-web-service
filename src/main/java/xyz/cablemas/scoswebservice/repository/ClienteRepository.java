package xyz.cablemas.scoswebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}
