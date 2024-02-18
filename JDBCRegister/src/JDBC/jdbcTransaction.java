package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTransaction {

	public static void main(String[] args) {
		Connection connection=null;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("1. load and register is completed");
	            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	            
	            System.out.println("2. connection has established");
	            Statement statement = connection.createStatement(); 
	            
	            System.out.println("3. Platform has created");
	            
	            connection.setAutoCommit(false);
	            
	            statement.execute("update emp set salary=salary-9000.00 where id=101");
	            System.out.println("4.Query 1 executed");
	            
	            statement.execute("update emp set salary=salary-5000.00 where id=105");
	            System.out.println("4.Query 2 executed");
	            
	            connection.commit();
	            
	    		 System.out.println("data commited");
			  } catch (ClassNotFoundException | SQLException e) {
		          try {
		        	  connection.rollback();
		        	  System.out.println("data rollback ");
		          } catch (SQLException e1) {
			  	        e.printStackTrace();
			          }
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
