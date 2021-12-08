package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;

	@Column(length = 50, nullable = false)
	private String nombres;

	@Column(length = 50, nullable = false)
	private String apellidos;

	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaDeNacimiento;

	@Column(length = 1, nullable = false)
	private Character sexo;

	@Column(length = 8, nullable = false, unique = true)
	private String dni;

	@Column(length = 9, nullable = false, unique = true)
	private String nroDeTelefonoMovil;

	@Column(length = 7, nullable = true)
	private String nroDeTelefonoFijo;

	@Column(length = 255, nullable = false)
	private String direccion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", nullable = false, unique = true)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_de_servicio_id", nullable = false)
	private TipoDeServicio tipoDeServicio;

}
