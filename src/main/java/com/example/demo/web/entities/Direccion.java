package com.example.demo.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"usuario"}) // excluir todas las referencias bidireccionales no necesarias en toString y equals and hashcode
@EqualsAndHashCode(exclude = {"usuario"}) // excluir todas las referencias bidireccionales no necesarias en toString y equals and hashcode
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental.
	private Long id;

	private String calle;

	@OneToOne // por default @OneToOne es EAGER.
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
}
