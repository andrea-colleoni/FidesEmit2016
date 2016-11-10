package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaProvaDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.16.99.13:3307/es4novembre";
			Connection conn = 
					DriverManager.getConnection(url, "emitfides", "password");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from autore");
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
