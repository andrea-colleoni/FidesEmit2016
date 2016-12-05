/**
 * @author aculnaig
 *
 */

import java.sql.*;

public class Inserimento {

	public static void main(String[] args) {

		// Crea un URL per connettersi al database 'scuola'
		String url = "jdbc:mysql://127.0.0.1:3306/scuola";
		Connection con;
		String sql = "INSERT INTO studente (matricola, nome, cognome) VALUES (0, 'Giuseppe', 'Verdi')";
		Statement stmt;

		// Connessione al database
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}

		try {
		        // getConnection(url, username, password)
		        // url: l'URL create all'inizio del main
			// username: il nome utente che avete scelto durante l'installaizone di MySQL
		        // password: la password che avete scelto durante l'installaizone di MySQL
			con  = DriverManager.getConnection(url, "", "");
			stmt = con.createStatement();

			// Esegue il comando SQL
			int righe = stmt.executeUpdate(sql);

			if (righe > 0)
				System.out.println("Record registrato");
			else
				System.out.println("Record non registrato");

			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}

	}

}
