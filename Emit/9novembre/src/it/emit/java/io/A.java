package it.emit.java.io;

import java.io.FileNotFoundException;

public class A {

	public void metodoA() throws MioErrorePersonalizzatoException {
		B b = new B();
		try {
			b.metodoB();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("L'eccezione è stata gestita!!");
		} 
	}
}
