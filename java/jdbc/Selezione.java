/**
 * @author aculnaig
 *
 */
import java.sql.*;

public class Selezione {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Crea l'URL per la connessione al database
		String url = "jdbc:mysql://127.0.0.1:3306/scuola";
		Connection con;
		String query = "SELECT matricola, nome, cognome " +
					   "FROM studente " + 
					   "WHERE studente.nome LIKE 'M%'";
		Statement stmt;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		
		try {
			con = DriverManager.getConnection(url, "", "");
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int matricola = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				
				// Visualizza i campi
				System.out.println("Matricola: " + matricola);
				System.out.println("Nome: " + nome);
				System.out.println("Cognome: " + cognome);
				System.out.println();
			}
			
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

}

