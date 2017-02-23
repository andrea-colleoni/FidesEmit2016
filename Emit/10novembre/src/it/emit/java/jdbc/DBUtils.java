package it.emit.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// carico il Driver
		Class.forName("com.mysql.jdbc.Driver");
		// dal driver ottengo la connessione
		String url = "jdbc:mysql://172.16.99.13:3307/es4novembre";
		Connection conn = DriverManager.getConnection(url, "emitfides", "password");
		return conn;
	}
	
}
