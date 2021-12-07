package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ubicaciones")
public class Ubicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ubicacionId;

	@Column(length = 100, nullable = false)
	private String direccion;

	@Column(nullable = false, columnDefinition = "float(10,6)")
	private float latitud;

	@Column(nullable = false, columnDefinition = "float(10,6)")
	private float longitud;

	@Column(updatable = false, nullable = false)
	private LocalDateTime fechaDeCreacion;

	@Column(updatable = true, nullable = false)
	private LocalDateTime fechaDeActualizacion;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
		fechaDeActualizacion = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		fechaDeActualizacion = LocalDateTime.now();
	}

}
