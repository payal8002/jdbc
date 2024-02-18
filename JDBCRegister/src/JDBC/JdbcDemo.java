package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection connection=null;
		Savepoint sp=null;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("1. load and register is completed");
	            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	            System.out.println("2. connection has established");
	            Statement statement = connection.createStatement(); 
	            System.out.println("3. Platform has created");
	            connection.setAutoCommit(false);
	            statement.execute("insert into emp values(105,'Akku',559000.00)");
	            System.out.println("4. Query 1 executed, accound has been created");
       	
	            statement.execute("update emp set salary=salary+5000.00 where id=105");
	            System.out.println("4. Query 2 executed, deposit successfull");
    		 sp=connection.setSavepoint();
    		 statement.execute("update emp set salary=salary-10000.00 where id=104");
    		 
    		 System.out.println("4. Query 3 executed, debit successfull");
    		 statement.execute("update emp set salary=salary+5000.00 where id=Mukesh");
    		 
    		 System.out.println("4. Query 4 executed, credit successfull");
    		 connection.commit();
    		 System.out.println("data commited");
		  } catch (ClassNotFoundException | SQLException e) {
	          try {
	        	  connection.rollback(sp);
	        	  System.out.println("data rollback after save point");
	        	  connection.commit();
	        	  System.out.println("data commited before save point");
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
    
  
        



