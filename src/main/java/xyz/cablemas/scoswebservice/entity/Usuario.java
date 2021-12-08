package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@Column(length = 20, nullable = false, unique = true)
	private String nombreDeUsuario;

	@Column(length = 60, nullable = false)
	private String contrasenia;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private Rol rol;

	@Column(nullable = false)
	private Boolean activo;

	@Column(length = 300, nullable = true)
	private String tokenDeNotificacion;

	@Column(updatable = false, nullable = false)
	private LocalDateTime fechaDeCreacion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ubicacion_id", nullable = true, unique = true)
	private Ubicacion ubicacion;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sede_id", nullable = false)
	private Sede sede;

	@PrePersist
	protected void onPersist() {
		fechaDeCreacion = LocalDateTime.now();
	}

}
