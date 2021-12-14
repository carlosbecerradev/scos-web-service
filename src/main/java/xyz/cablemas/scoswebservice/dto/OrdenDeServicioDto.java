package xyz.cablemas.scoswebservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdenDeServicioDto {
	private Long id;
	private String tipoDeIncidencia;
	private String descripcionDelProblema;
	private String imagenUrl;
	private ClienteDto cliente;
	private EmpleadoDto empleado;
	private String estado;
	private LocalDateTime fechaDeCreacion;
	private LocalDateTime fechaDeAsignacion;
	private LocalDateTime fechaDeLlegada;
	private LocalDateTime fechaDeResolucion;
	private LocalDateTime fechaDeCancelacion;
	private LocalDateTime fechaDeCierre;
	private String motivoDeCancelacion;
	private Boolean revisada;
}
