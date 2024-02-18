package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JdbcBatch {
	public static void main(String[] args) {
		Connection connection=null;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("1. load and register is completed");
	            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	            
	            System.out.println("2. connection has established");
	            Statement statement = connection.createStatement(); 
	            
	            System.out.println("3. Platform has created");
	            
	            statement.addBatch("insert into emp values (112,'Leon',5000.00)");
	            System.out.println("Query 1 added");
	            
	            statement.addBatch("update emp set salary=salary+5000.00");
	            System.out.println("Query 2 added");
	            
	            statement.addBatch("delete from emp where salary<10000");
	            System.out.println("Query 3 added");
	            
	            int[] batch = statement.executeBatch();
	            System.out.println(Arrays.toString(batch));
	            
		 } catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }finally {
       	  try {
       	  connection.close();
       	  System.out.println("6.connection has been closed");
       	  
         } catch (SQLException e) {
	  	        e.printStackTrace();
		 }
	}
 }
}
