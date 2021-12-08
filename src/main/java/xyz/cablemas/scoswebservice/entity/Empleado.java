package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empleadoId;

	@Column(length = 50, nullable = false)
	private String nombres;

	@Column(length = 50, nullable = false)
	private String apellidos;

	@Column(length = 255, nullable = false)
	private String fotoUrl;

	@Column(length = 9, nullable = false)
	private String nroDeCarnet;

	@Column(length = 8, nullable = false)
	private String dni;

	@Column(length = 9, nullable = false)
	private String nroDeTelefonoMovil;

	@Column(length = 1, nullable = false)
	private Character sexo;

	@Column(length = 15, nullable = false)
	private String estado;

}
