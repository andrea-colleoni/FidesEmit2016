package it.emit.java.jdbc;

public class TestDaoLibro {

	public static void main(String[] args) {
		LibroDao ld = new LibroDao();

		ld.tutti().stream()
			.filter(k -> k.getTitolo().contains("Potter"))
			.forEach(l -> System.out.println(l.getAutore().getCognome()));
		
		
		Libro l = new Libro();
		l.setTitolo("Manuale di Java");
		l.setAnnoPubblicazione(2016);
		l.setIsbn("2345676543");
		l.setNumeroPagine(10);
		l.setCasaEditrice("Emit");
		ld.inserisci(l);
		
		
		l = ld.libroPerIsbn("111");
		ld.elimina(l);
	}

}
