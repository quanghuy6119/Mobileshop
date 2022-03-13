package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MSSQLJDBCConnection {

	public static Connection getJDBCConnection() {
		final String user= "sa";
		final String password = "admin123";
		String serverName = "localhost";
		String dbName = "ShoppingDB";
		String url = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
