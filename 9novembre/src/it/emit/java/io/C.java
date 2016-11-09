package it.emit.java.io;

public class C {
	
	public void metodoC() throws MioErrorePersonalizzatoException {
		String a = "ciccio";
		try {
			System.out.println(a.length());
			MioErrorePersonalizzatoException errore = 
					new MioErrorePersonalizzatoException("Questo è un errore personalizzato");
			throw errore;
		} catch (NullPointerException e) {
			System.err.println("La stringa è nulla");
		}
	}
}
