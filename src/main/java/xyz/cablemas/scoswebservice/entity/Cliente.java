package xyz.cablemas.scoswebservice.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column
	private LocalDate fechaNacimiento;

	@Column(length = 1, nullable = false)
	private Character sexo;

	@Column(length = 8, nullable = false, unique = true)
	private String dni;

	@Column(length = 9, nullable = false, unique = true)
	private String nroTelefonoMovil;

	@Column(length = 7, nullable = true)
	private String nroTelefonoFijo;

	@Column(length = 255, nullable = false)
	private String direccion;

}
