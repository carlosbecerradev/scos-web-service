package xyz.cablemas.scoswebservice.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import xyz.cablemas.scoswebservice.entity.Ubicacion;

@Data
@Builder
public class ClienteDto {
	private Long id;
	private String nombres;
	private String apellidos;
	private LocalDate fechaDeNacimiento;
	private Character sexo;
	private String dni;
	private String nroDeTelefonoMovil;
	private String nroDeTelefonoFijo;
	private String direccion;
	private Long usuarioId;
	private String tokenDeNotificacion;
	private Ubicacion ubicacion;
	private String sede;
	private String tipoDeServicio;
}
