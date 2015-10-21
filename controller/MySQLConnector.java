package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
	public static Connection connectDatabase(String host, String db, String username, String password) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		return DriverManager.getConnection("jdbc:mysql://" + host + "/" + db, username, password);
	}
}
