/**
 * @author aculnaig
 *
 */

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudenteDAO {
	
	public void inserisci(Studente s) {
		try (Connection con = DBUtil.getConnection()) {
			String sql = "INSERT INTO studente " +
				     "(matricola, nome, cognome) " +
				     "VALUES " +
				     "(?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			mappaturaRecord(s, ps);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void aggiorna(Studente s) {
		try (Connection con = DBUtil.getConnection()) {
			String sql = "UPDATE studente SET " +
				     "nome=?, " +
				     "cognome=? " +
				     "WHERE matricola=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			mappaturaRecord(s, ps);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Studente studentePerMatricola(int matricola) {
		Studente s = null;
		
		try (Connection con = DBUtil.getConnection()) {
			String sql = "SELECT * FROM studente WHERE matricola = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, matricola);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				s = mappaturaOggetto(rs);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return s;
	}
	
	private Studente mappaturaOggetto(ResultSet rs) throws SQLException {
		Studente s = new Studente();
		
		s.setMatricola(rs.getInt("matricola"));
		s.setNome(rs.getString("nome"));
		s.setCognome(rs.getString("cognome"));
		
		return s;
	}
	
	private void mappaturaRecord(Studente s, PreparedStatement ps) throws SQLException {
		ps.setInt(1, s.getMatricola());
		ps.setString(2, s.getNome());
		ps.setString(3, s.getCognome());
	}

}
