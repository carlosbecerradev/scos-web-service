package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes_de_servicio")
public class OrdenDeServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordenDeServicioId;

	@Column(nullable = false, updatable = false)
	private LocalDateTime fechaDeCreacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaDeAsignacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaDeLlegada;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaDeResolucion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaDeCancelacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaDeCierre;

	@Column(length = 15, nullable = false)
	private String estado;

	@Column(length = 255, nullable = true)
	private String descripcionDelProblema;

	@Column(length = 255, nullable = true)
	private String imagenUrl;

	@Column(length = 255, nullable = true)
	private String motivoDeCancelacion;

	@Column(nullable = false)
	private boolean revisada;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
	}

}
