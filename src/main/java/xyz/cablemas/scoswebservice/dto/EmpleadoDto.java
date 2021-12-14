package xyz.cablemas.scoswebservice.dto;

import lombok.Builder;
import lombok.Data;
import xyz.cablemas.scoswebservice.entity.Ubicacion;

@Data
@Builder
public class EmpleadoDto {
	private Long id;
	private String nombres;
	private String apellidos;
	private String fotoUrl;
	private String nroDeCarnet;
	private String dni;
	private String nroDeTelefonoMovil;
	private Character sexo;
	private String estado;
	private Long usuarioId;
	private String tokenDeNotificacion;
	private Ubicacion ubicacion;
	private String sede;
}
