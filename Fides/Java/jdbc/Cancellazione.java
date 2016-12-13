/**
 * @author aculnaig
 *
 */
import java.sql.*;

public class Cancellazione {

	public static void main(String[] args) {
		
		// Crea un URL per connettersi al database 'scuola'	
		String url = "jdbc:mysql://127.0.0.1:3306/scuola";
		Connection con;
		String sql = "DELETE FROM studente WHERE matricola = 0";
		Statement stmt;
		int righe;
		
		// Connessiona al database
		try {
			// Carico il driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		
		try {
			// getConnection(url, username, password)
			// url: l'URL creato all'inizio del main
                        // username: il nome utente che avete scelto durante l'installaizone di MySQL
                        // password: la password che avete scelto durante l'installaizone di MySQL
			con  = DriverManager.getConnection(url, "", "");
			stmt = con.createStatement();

			// Esegue il comando SQL
			righe = stmt.executeUpdate(sql);
			
			if (righe > 0)
				System.out.println("Record eliminato.");
			
			else 
				System.out.println("Record da eliminare non trovato");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
	}

}
