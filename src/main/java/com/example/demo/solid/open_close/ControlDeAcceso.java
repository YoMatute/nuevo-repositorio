package com.example.demo.solid.open_close;

import java.util.Random;

// es myy abstracto, es muy ambigua, puedes permitir acceso, OCR, tarjeta, boleto, manual
public abstract class ControlDeAcceso {
	
	protected Random rand = new Random();
	
	public abstract boolean validarAcceso();

}
