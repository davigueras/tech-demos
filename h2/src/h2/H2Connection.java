package h2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class H2Connection {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	public H2Connection() {
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:database", "user", "password");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void test() {
		try {
			resultSet = statement.executeQuery("SELECT * FROM database.person");
			while (resultSet.next()) {
				System.out.println("Id: " + resultSet.getInt("id") + "\t\t\t Name: " + resultSet.getString("name"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
