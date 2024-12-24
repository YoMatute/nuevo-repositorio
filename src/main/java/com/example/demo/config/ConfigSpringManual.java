package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.manual.Persona;

@Configuration // En automatico, esta clase de config también es un bean
public class ConfigSpringManual {

	// Bean: un bean es un objeto, construido, instanciado, configurado, destruidos, manejado por spring.
	// por default los beans son de scope "singleton". Es decir unica instancia en el contexto de spring.
	
	@Bean
	@Scope(scopeName = "singleton") // unica instancia
	public Persona pepe() { // nombre del metodo es el nombre del bean
		return Persona.builder().nombre("Pepe pecas").edad(40).build();
	}
	
	@Bean
	@Scope(scopeName = "prototype") // spring te da un bean nuevo cada que pidas este bean
	public Persona maria() { // nombre del metodo es el nombre del bean
		return Persona.builder().nombre("Maria").edad(30).build();
	}

}
