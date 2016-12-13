/**
 * @author aculnaig
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// Carico il driver
		Class.forName("com.mysql.jdbc.Driver");
		// Ottengo la connessione dal driver
		String url = "jdbc:mysql://127.0.0.1:3306/scuola";
		Connection con = DriverManager.getConnection(url, "", "");
		
		return con;
	}

}
