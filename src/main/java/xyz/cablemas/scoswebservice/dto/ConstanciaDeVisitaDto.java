package xyz.cablemas.scoswebservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConstanciaDeVisitaDto {
	private Long id;
	private String imagenUrl;
	private LocalDateTime fechaDeCreacion;
	private Long ordenDeServicioId;
}
