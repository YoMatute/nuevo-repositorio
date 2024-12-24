package com.example.demo.solid.open_close;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ControlAccesoOCR extends ControlDeAcceso {

	@Override
	public boolean validarAcceso() {
		
		log.info("Leyendo placas de auto");

		return rand.nextBoolean();

	}

}
