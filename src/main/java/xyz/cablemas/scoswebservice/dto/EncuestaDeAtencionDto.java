package xyz.cablemas.scoswebservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import xyz.cablemas.scoswebservice.entity.Valoracion;

@Data
@Builder
public class EncuestaDeAtencionDto {
	private Long id;
	private Valoracion valoracion;
	private String observacion;
	private Boolean omitida;
	private LocalDateTime fechaDeCreacion;
	private Long ordenDeServicioId;
}
