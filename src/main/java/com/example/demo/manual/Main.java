package com.example.demo.manual;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.ConfigSpringManual;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigSpringManual.class);
		// cuando termina de cargar spring, apartir de aqui.
		// toooodos los ojbetos, beans, manejados por spring YA existen.

		// ctx.getBean("pepe") siempre devuelve el mismo bean, por que es singleton
		Persona pepe = ctx.getBean("pepe", Persona.class); // new Persona() esto NO pasa, por que son singleton.
		Persona pepe2 = ctx.getBean("pepe", Persona.class);
		
		Persona maria = ctx.getBean("maria", Persona.class); // es prototype, new Persona("Maria"), esto si pasa
		Persona maria2 = ctx.getBean("maria", Persona.class); // es prototype, new Persona("Maria"), esto si pasa
		
		// En este ejemplo estoy pidiendo... NO me estan inyectando.
		// Pero SI estoy invirtiendo el control. (por que el programador NO esta haciendo new Persona())
		
		

		log.info("pepe: {}", pepe);
		log.info("pepe2: {}", pepe2);

		log.info("pepe.equals(pepe2): {}", pepe.equals(pepe2));
		log.info("pepe == pepe2: {}", pepe == pepe2);

		log.info("================");
		
		log.info("maria: {}", maria);
		log.info("pepe.equals(maria): {}", pepe.equals(maria));
		log.info("pepe == maria: {}", pepe == maria);
		
		log.info("================");
		
		log.info("maria: {}", maria);
		log.info("maria2: {}", maria2);
		log.info("maria.equals(maria2): {}", maria.equals(maria2));
		log.info("maria == maria2: {}", maria == maria2);

		ctx.close();
	}

}
