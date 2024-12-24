package com.example.demo.manual;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	private String nombre;
	private int edad;
	
	@PostConstruct // inicializacion despues de que el objeto se instancia
	public void decirHola() {
		System.out.println("Hola mundo, soy: "+nombre+" !!!");
	}
	
	@PreDestroy // destrucción del objeto, justo antes de que el contexto se apague.
	public void decirAdios() {
		System.out.println("Adios mundo cruel, soy: "+nombre);
	}
	
}
