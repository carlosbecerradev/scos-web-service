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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipos_de_incidencia")
public class TipodeIncidencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoDeIncidenciaId;

	@Column(length = 20, nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Boolean activo;

	@Column(updatable = false, nullable = false)
	private LocalDateTime fechaDeCreacion;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
	}

}
