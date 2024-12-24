package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.web.entities.Direccion;
import com.example.demo.web.entities.Usuario;
import com.example.demo.web.repositories.DireccionRepository;
import com.example.demo.web.repositories.UsuarioRepository;

//Principales diferencias entre Spring Framework vs Spring Boot.

// Spring Framework, es el framework de Inversion de Control e Inyeccion de
// dependencias más popular en java.
// Nos provee de multiples herramientas, clases, componentes, principios de
// programación, metodologias, etc
// para desarrollar aplicaciones java empresariales.

// Spring Boot, se construye sobre Spring Framework para automatizar la
// configuración del proyecto de spring
// basandose en el escaneo de sus dependencias (pom.xml).
// Spring boot se autoconfigura, en base a las dependencias que encuentre en el
// pom.

// Spring boot 2.x => Spring Framework 5
// Spring boot 3.x => Spring Framework 6

// Crear un CRUD
@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner aplicacionInicia(UsuarioRepository usuarioRepo, DireccionRepository direccionRepo) {
		return (args) -> {
			
			Direccion direccion = Direccion.builder()
					.calle("Marmota 232, Col. del Valle.")
					.build();
			
			Usuario alejandro = Usuario.builder()
					.nombre("Alejandro")
					.direccion(direccion)
					.build();
			
			direccion.setUsuario(alejandro);
			
			usuarioRepo.save(alejandro);
			
			
			Direccion dirAlejandro = direccionRepo.findById(direccion.getId()).get();
			
			System.out.println(dirAlejandro);
		};
	}

	
	
}







