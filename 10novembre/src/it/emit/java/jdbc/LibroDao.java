package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDao {

	public void inserisci(Libro l) {
		try (Connection conn = getConnection()) {
			String sql = "INSERT INTO libro ("
					+ "ISBN, "
					+ "TITOLO, "
					+ "CASA_EDITRICE, "
					+ "ANNO_PUBBLICAZIONE, "
					+ "N_PAGINE, "
					+ "CODICE_GENERE, "
					+ "CODICE_AUTORE"
					+ ") VALUES ("
					+ "?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, l.getIsbn());
			st.setString(2, l.getTitolo());
			st.setString(3, l.getCasaEditrice());
			st.setInt(4, l.getAnnoPubblicazione());
			st.setInt(5, l.getNumeroPagine());
			st.setInt(6, 1);
			st.setInt(7, 1);
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aggiorna(Libro l) {
		try (Connection conn = getConnection()) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void elimina(Libro l) {
		try (Connection conn = getConnection()) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Libro> tutti() {
		List<Libro> tuttiILibri = new ArrayList<>();
		try (Connection conn = getConnection()) {
			// dalla connessione ottengo l'oggetto per inviare comandi
			Statement st = conn.createStatement();
			// eseguendo il comando ottendo i dati unitamente ai metadati
			ResultSet rs = st.executeQuery("SELECT * from libro");
			// per accedere ai dati uso il cursore
			while (rs.next()) {
				Libro l = mappaturaOggetto(rs);
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
		try (Connection conn = getConnection()) {
			// dalla connessione ottengo l'oggetto per inviare comandi
			String sql = "select * from libro WHERE ISBN=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, isbn);
			ResultSet rs = st.executeQuery();
			// per accedere ai dati uso il cursore
			if (rs.next()) {
				libro = mappaturaOggetto(rs);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// carico il Driver
		Class.forName("com.mysql.jdbc.Driver");
		// dal driver ottengo la connessione
		String url = "jdbc:mysql://172.16.99.13:3307/es4novembre";
		Connection conn = DriverManager.getConnection(url, "emitfides", "password");
		return conn;
	}

	private Libro mappaturaOggetto(ResultSet rs) throws SQLException {
		Libro l = new Libro();
		l.setIsbn(rs.getString("ISBN"));
		l.setTitolo(rs.getString("TITOLO"));
		l.setCasaEditrice(rs.getString("CASA_EDITRICE"));
		l.setAnnoPubblicazione(rs.getInt("ANNO_PUBBLICAZIONE"));
		l.setNumeroPagine(rs.getInt("N_PAGINE"));
		return l;
	}

}
