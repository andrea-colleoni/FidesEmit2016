package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaProvaDB {

	public static void main(String[] args) {
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
			ResultSet rs = st.executeQuery("SELECT * from autore");
			// ai metadati accedo in questo modo
			ResultSetMetaData rsmd = rs.getMetaData();
			// per accedere ai dati uso il cursore
			while(rs.next()) {
				System.out.println(rs.getString("cognome"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
