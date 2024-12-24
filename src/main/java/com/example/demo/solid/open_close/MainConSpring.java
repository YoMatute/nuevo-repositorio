package com.example.demo.solid.open_close;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.ConfigSpringControlAcceso;

public class MainConSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigSpringControlAcceso.class);

		SimulacionAccesos sim = ctx.getBean(SimulacionAccesos.class);
		
		sim.simularAccesos();
		
		ctx.close();

	}

}
