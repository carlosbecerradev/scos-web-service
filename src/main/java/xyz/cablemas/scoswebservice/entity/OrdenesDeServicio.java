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
public class OrdenesDeServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordenesId;

	@Column(nullable = false, updatable = false)
	private LocalDateTime fechaCreacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaAsignacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaLlegada;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaResolucion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaCancelacion;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = true)
	private LocalDateTime fechaCierre;

	@Column(length = 15, nullable = false)
	private String estado;

	@Column(length = 255, nullable = true)
	private String descripcionProblema;

	@Column(length = 255, nullable = true)
	private String imagenUrl;

	@Column(length = 18, nullable = true)
	private String motivoCancelacion;

	@Column(nullable = false)
	private boolean revisada;

	@PrePersist
	protected void onPersist() {
		fechaCreacion = LocalDateTime.now();
	}

}
