package jdbcPratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class studUtils {
	public static Connection buildConnection() throws SQLException {
		String connectionUrl="jdbc:mysql://localhost:3306/cdac";
		String userName="root";
		String password="password";
		Connection stConnection = DriverManager.getConnection(connectionUrl,userName,password);
		return stConnection;
	}

}
