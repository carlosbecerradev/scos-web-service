package xyz.cablemas.scoswebservice.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xyz.cablemas.scoswebservice.dto.ReporteTecnicoPorOrdenDeServicio;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;

public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Long> {

	Collection<OrdenDeServicio> findByClienteUsuarioSedeNombre(String sede);

	@Query(value = "SELECT " + "o.orden_de_servicio_id as ordenId, "
			+ "concat(e.nombres, ' ', e.apellidos) as tecnico, " + "e.nro_de_carnet as nroDeCarnet, "
			+ "concat(c.nombres, ' ', c.apellidos) as cliente, " + "ti.nombre as tipoDeIncidencia, "
			+ "o.fecha_de_creacion as fechaDeCreacion, "
			+ "ROUND((TIME(o.fecha_de_asignacion) - TIME(o.fecha_de_creacion))/100) as duracionDeEspera, "
			+ "ROUND((TIME(o.fecha_de_llegada) - TIME(o.fecha_de_asignacion))/100) as duracionDeRecorrido, "
			+ "ROUND((TIME(o.fecha_de_resolucion) - TIME(o.fecha_de_llegada))/100) as duracionDeResolucion, "
			+ "ROUND((TIME(o.fecha_de_cierre) - TIME(o.fecha_de_resolucion))/100) as duracionDeEncuesta, "
			+ "enc.valoracion, o.estado " + "FROM ordenes_de_servicio o " + "INNER JOIN empleados e "
			+ "ON o.empleado_id = e.empleado_id " + "INNER JOIN encuestas_de_atencion enc "
			+ "ON o.orden_de_servicio_id = enc.orden_de_servicio_id " + "INNER JOIN tipos_de_incidencia ti "
			+ "ON o.tipo_de_incidencia_id = ti.tipo_de_incidencia_id " + "INNER JOIN clientes c "
			+ "ON o.cliente_id = c.cliente_id " + "INNER JOIN usuarios u " + "ON c.usuario_id = u.usuario_id "
			+ "INNER JOIN sedes s " + "ON s.sede_id = u.sede_id "
			+ "WHERE o.estado = 'CERRADA' AND s.nombre = :sede ", nativeQuery = true)
	Collection<ReporteTecnicoPorOrdenDeServicio> reporteTecnicos(@Param("sede") String sede);
	
	@Query(value ="SELECT * FROM db_scos.ordenes_de_servicio o "
			+ "INNER JOIN db_scos.clientes c "
			+ "ON o.cliente_id = c.cliente_id "
			+ "WHERE c.cliente_id = :clienteId "
			+ "ORDER BY o.fecha_de_creacion DESC "
			+ "LIMIT 1 ", nativeQuery= true)
	Optional<OrdenDeServicio> ultimaOrdenDelCliente(@Param("clienteId") Long clienteId);
	
	@Query(value="SELECT * FROM db_scos.ordenes_de_servicio o "
			+ "INNER JOIN db_scos.empleados e "
			+ "ON o.empleado_id = e.empleado_id "
			+ "WHERE e.empleado_id = :tecnicoId "
			+ "ORDER BY o.fecha_de_creacion DESC "
			+ "LIMIT 1", nativeQuery = true)
	Optional<OrdenDeServicio> ultimaOrdenDelTecnico(@Param("tecnicoId") Long tecnicoId);
}
