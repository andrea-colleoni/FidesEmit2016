/**
 * Aggiorna un record con i dati inseriti da tastiera
 */

/**
 * @author aculnaig
 *
 */

import java.io.*;
import java.sql.*;

public class Aggiornamento {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		int matricola;
		String nome, cognome;
		String query = "UPDATE studente " +
			       "SET nome=?, cognome=? " +
	     		       "WHERE matricola = ?";
		
		try {
			// Crea un URL per connettersi al database
			String url = "jdbc:mysql://127.0.0.1:3306/scuola";
			
			// Connessione al database
			try {
				// Carico il driver
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.err.println("ClassNotFoundException: " + e.getMessage());
			}
			
			// Ottengo la connessione
			Connection con = DriverManager.getConnection(url, "", "");
			
			// Statement di preparazione all'aggiornamento con due parametri
			PreparedStatement stmt = con.prepareStatement(query);
			
			// Inserimento da tastiera dei dati
			try {
				System.out.print("Matricola: ");
				String mat = br.readLine();
				matricola = Integer.valueOf(mat).intValue();
			} catch (Exception e) {
				System.err.println("\nNumero di matricola non trovato.");
				return;
			}
			
			try {
				System.out.print("Nome: ");
				nome = br.readLine();
				System.out.print("Cognome: ");
				cognome = br.readLine();
			} catch (Exception e) {
				System.err.println("\nInserimento nome e/o cognome errato.");
				return;
			}
			
			// Esegue il comando SQL
			stmt.setInt(1, matricola);
			stmt.setString(2, nome);
			stmt.setString(3, cognome);
			int righe = stmt.executeUpdate();
			
			if (righe > 0)
				System.out.println("Aggiornameto record: OK.");
			
			else
				System.out.println("Aggiornamento record: FAILED.");
			
			stmt.close();
			con.close();
			
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

}
