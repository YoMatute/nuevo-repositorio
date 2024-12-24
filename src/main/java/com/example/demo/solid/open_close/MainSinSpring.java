package com.example.demo.solid.open_close;

public class MainSinSpring {
	
	public static void main(String[] args) {
		
		// Puedes o no instanciar una clase abstracta, NO puedes
		ControlDeAcceso cda_tarjeta = new ControlDeAccesoTarjeta(); // instanciando manualmente
		
		
		// Liskov substitution. 
		// Aqui puedes pasar la clase padre (la clase que te pide el metodo) o cualquiera de sus sublcases.
		// Liskov substitution, no es mas que simplemente aplicar polimorfismo.
		// si esto no se rompe, esta bien aplicado el principio de Liskov.
		Pluma pluma = new Pluma(cda_tarjeta); // inyectando la dependencia, programaticamente
		
		boolean acceso = pluma.permitirAcceso();
		
		System.out.println(acceso);
		
		ControlDeAcceso cda_boleto = new ControlDeAccesoBoleto(); // instanciando manualmente
		
		pluma.setControlAcceso(cda_boleto); // inyectando de forma manual, programaticamente
		
		acceso = pluma.permitirAcceso();
		
		System.out.println(acceso);
		System.out.println();
	}

}
