package xyz.cablemas.scoswebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
