package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.solid.open_close.ControlDeAccesoTarjeta;
import com.example.demo.solid.open_close.Pluma;

@Configuration // En automatico, esta clase de config también es un bean
@ComponentScan(basePackages = { "com.example.demo.solid.open_close" })
public class ConfigSpringControlAcceso {

	// Bean pluma:
	@Bean // Java config, configuracion programatica
	public Pluma pluma(ControlDeAccesoTarjeta cdaT) {
		Pluma p = new Pluma(cdaT);
		return p;
	}

}
