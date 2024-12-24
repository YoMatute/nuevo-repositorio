package com.example.demo.solid.open_close;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pluma {
	
	// Este diseño habilita la Open-close.

	// No se debe instanciar, Dependency Inversion
	@Setter
	private ControlDeAcceso controlAcceso; // patrón strategy.
	
	public Pluma(ControlDeAcceso controlDeAcceso) { // Habilitamos inyeccion de dep. por medio de constructor
		this.controlAcceso = controlDeAcceso;
	}
	
	public final boolean permitirAcceso() {
		
		// validar Acceso
		boolean accesoValido = controlAcceso.validarAcceso();
		
		// levanta pluma o no
		return levantaPluma(accesoValido);
	}

	private boolean levantaPluma(boolean accesoValido) {
		
		if(accesoValido) {
			log.info("levantando pluma");
			return true;
		} else {
			log.info("No permite acceso");
			return false;
		}
	}
}
