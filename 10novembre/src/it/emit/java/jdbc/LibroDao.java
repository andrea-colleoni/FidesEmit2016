package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDao {
	
	public void inserisci(Libro l) {
		
	}
	
	public void aggiorna(Libro l) {
		
	}
	
	public void elimina(Libro l) {
		
	}
	
	public List<Libro> tutti() {
		List<Libro> tuttiILibri = new ArrayList<>();
		try {
			// carico il Driver
			Class.forName("com.mysql.jdbc.Driver");
			// dal driver ottengo la connessione
			String url = "jdbc:mysql://172.16.99.13:3307/es4novembre";
			Connection conn = 
					DriverManager.getConnection(url, "emitfides", "password");
			// dalla connessione ottengo l'oggetto per inviare comandi
			Statement st = conn.createStatement();
			// eseguendo il comando ottendo i dati unitamente ai metadati
			ResultSet rs = st.executeQuery("SELECT * from libro");
			// per accedere ai dati uso il cursore
			while(rs.next()) {
				Libro l = new Libro();
				l.setIsbn(rs.getString("ISBN"));
				l.setTitolo(rs.getString("TITOLO"));
				l.setCasaEditrice(rs.getString("CASA_EDITRICE"));
				l.setAnnoPubblicazione(rs.getInt("ANNO_PUBBLICAZIONE"));
				l.setNumeroPagine(rs.getInt("N_PAGINE"));
				tuttiILibri.add(l);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tuttiILibri;
	}
	
	public Libro libroPerIsbn(String isbn) {
		Libro libro = null;
		try {
			// carico il Driver
			Class.forName("com.mysql.jdbc.Driver");
			// dal driver ottengo la connessione
			String url = "jdbc:mysql://172.16.99.13:3307/es4novembre";
			Connection conn = 
					DriverManager.getConnection(url, "emitfides", "password");
			// dalla connessione ottengo l'oggetto per inviare comandi
			Statement st = conn.createStatement();
			// eseguendo il comando ottendo i dati unitamente ai metadati
			ResultSet rs = st.executeQuery("SELECT * from libro");
			// per accedere ai dati uso il cursore
			while(rs.next()) {
				Libro l = new Libro();
				l.setIsbn(rs.getString("ISBN"));
				l.setTitolo(rs.getString("TITOLO"));
				l.setCasaEditrice(rs.getString("CASA_EDITRICE"));
				l.setAnnoPubblicazione(rs.getInt("ANNO_PUBBLICAZIONE"));
				l.setNumeroPagine(rs.getInt("N_PAGINE"));
				tuttiILibri.add(l);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tuttiILibri;		
	}

}
