package com.example.demo.solid.open_close;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("simulador") // default, es singleton
@AllArgsConstructor
public class SimulacionAccesos {

	// @Autowired // @Autowired a nivel de propiedad, sin setter, es una mala practica.
	private Pluma pluma;

	public void simularAccesos() {
		boolean acceso = pluma.permitirAcceso();

		System.out.println(acceso);

	}

}
