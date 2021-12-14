package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "encuestas_de_atencion")
public class EncuestaDeAtencion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long encuestaDeAtencionId;

	@Column(length = 10, nullable = false)
	private String valoracion;

	@Column(length = 255, nullable = true)
	private String observacion;

	@Column(nullable = false)
	private Boolean omitida;

	@Column(updatable = false, nullable = false)
	private LocalDateTime fechaDeCreacion;

	@OneToOne
	@JoinColumn(name = "orden_de_servicio_id", nullable = false, unique = true)
	private OrdenDeServicio ordenDeServicio;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
	}

}
