package com.example.demo.web.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"pedidos"}) // excluir TODO lo LAZY
@EqualsAndHashCode(exclude = {"pedidos"}) // excluir TODO lo LAZY
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental.
	private Long id;

	@Column(name = "NOMBRE_USUARIO")
	private String nombre;
	
	// Si defines relaciones LAZY, quita los Getters, porque el getter dispara la consulta.
	// Si defines relaciones EAGER, puedes dejar los Getters. Cuidado, puedes estarte trayendo toda la BD.
	// Esta prohibido, usar fetch EAGER en relaciones 1 a muchos.
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Direccion direccion;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	@Getter(AccessLevel.NONE)
	private List<Pedido> pedidos;
}
