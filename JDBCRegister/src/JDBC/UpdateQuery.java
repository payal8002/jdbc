package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class UpdateQuery {

	public static void main(String[] args) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");//passing qualify name of Driver class
	         System.out.println("1. load and register is completed");
	         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	         System.out.println("2. connection has established"); 
	         Statement statement = connection.createStatement();  
	         System.out.println("3. Platform has created");
		     int rowEffect = statement.executeUpdate("update student set stream = stream + CS");
		     System.out.println("4. Query execute, number of row effected: " +rowEffect);
		} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
		}
  }
}
