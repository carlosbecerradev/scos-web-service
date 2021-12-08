package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
@Table(name = "constancias_de_visita")
public class ConstanciaDeVisita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long constanciaDeVisitaId;

	@Column(length = 255, nullable = false)
	private String imagenUrl;

	@Column(updatable = false, nullable = false)
	private LocalDateTime fechaDeCreacion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orden_de_servicio_id", nullable = false, unique = true)
	private OrdenDeServicio ordenDeServicio;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
	}

}
