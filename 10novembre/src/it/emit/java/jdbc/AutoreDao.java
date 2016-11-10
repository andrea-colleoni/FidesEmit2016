package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutoreDao {
	
	public void inserisci(Autore a) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "INSERT INTO autore ("
					+ "CODICE_AUTORE, "
					+ "NOME, "
					+ "COGNOME, "
					+ "ANNO_NASCITA, "
					+ "NAZIONALITA, "
					+ "CODICE_GENERE "
					+ ") VALUES ("
					+ "?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			mappaturaRecord(a, st);
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void aggiorna(Autore a) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "UPDATE libro SET "
					+ "CODICE_AUTORE=?, "
					+ "NOME=?, "
					+ "COGNOME=?, "
					+ "ANNO_NASCITA=?, "
					+ "NAZIONALITA=?, "
					+ "CODICE_GENERE=? "
					+ "WHERE  CODICE_AUTORE=?";
			PreparedStatement st = conn.prepareStatement(sql);
			mappaturaRecord(a, st);
			st.setInt(7, a.getCodice());
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void elimina(Autore a) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "DELETE FROM autore WHERE  CODICE_AUTORE=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, a.getCodice());
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Autore> tutti() {
		List<Autore> tuttiAutori = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection()) {
			// dalla connessione ottengo l'oggetto per inviare comandi
			Statement st = conn.createStatement();
			// eseguendo il comando ottendo i dati unitamente ai metadati
			ResultSet rs = st.executeQuery("SELECT * from autore");
			// per accedere ai dati uso il cursore
			while (rs.next()) {
				Autore a = mappaturaOggetto(rs);
				tuttiAutori.add(a);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tuttiAutori;
	}

	public Autore autorePerCodice(int codice) {
		Autore autore = null;
		try (Connection conn = DBUtils.getConnection()) {
			// dalla connessione ottengo l'oggetto per inviare comandi
			String sql = "select * from autore WHERE CODICE_AUTORE=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, codice);
			ResultSet rs = st.executeQuery();
			// per accedere ai dati uso il cursore
			if (rs.next()) {
				autore = mappaturaOggetto(rs);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autore;
	}


	private Autore mappaturaOggetto(ResultSet rs) throws SQLException {
		Autore a = new Autore();
		a.setCodice(rs.getInt("CODICE_AUTORE"));
		a.setNome(rs.getString("NOME"));
		a.setCognome(rs.getString("COGNOME"));
		a.setAnnoNascita(rs.getInt("ANNO_NASCITA"));
		a.setNazionalita(rs.getString("NAZIONALITA"));
		
		// non posso fare questa cosa senza pensarci bene...
		// ho il problema che andrei in un loop infinito di chiamate
		// (StackOverflow oppure Connessioni verso il DB esaurute)
		// dovrei risolvere in altro modo, ma useremo JPA per risolvere
		
//		LibroDao ld = new LibroDao();
//		List<Libro> libriAutore = new ArrayList<>();
//		ld.tutti().stream()
//			.filter(l -> l.getAutore().getCodice() == a.getCodice())
//			.forEach(l -> libriAutore.add(l));
//		a.setLibri(libriAutore);
		return a;
	}
	
	private void mappaturaRecord(Autore a, PreparedStatement st) throws SQLException {
		st.setInt(1, a.getCodice());
		st.setString(2, a.getNome());
		st.setString(3, a.getCognome());
		st.setInt(4, a.getAnnoNascita());
		st.setString(5, a.getNazionalita());
		st.setInt(6, 1);
	}	
}
