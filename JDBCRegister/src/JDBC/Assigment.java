package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Assigment{

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		try{
	         Class.forName("com.mysql.cj.jdbc.Driver");//passing qualify name of Driver class
	         System.out.println("1. load and register is completed");
	         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	         System.out.println("2. connection has established"); 
	         Statement statement = connection.createStatement();  
	         System.out.println("3. Platform has created");
	         System.out.println("do you want to register Y/N");
	         
			String yn = sc.nextLine();
	         int id = 100;
	         while(yn .equalsIgnoreCase("y")) {
	        	 System.out.println("Enter your name");
	        	 String name =  sc.nextLine();
	        	 System.out.println("Enter your ");
	        	 String department =  sc.nextLine();
	        	 System.out.println("Enter your score");
	        	 double score = sc.nextDouble();
	        	 if(score<=60.0) {
	        		 System.out.println("Sorry your score is below 60 so you are not allowed");
	        	 }else {
	        		 statement.execute("insert into student1 values("+id+"','"+department+"','"+score+")");
	        		 System.out.println("You are register successfully");
	        		 id++;
	        	 }
	        	  System.out.println("do you want to register Y/N");
	        	  sc.nextLine();
	        	  yn=sc.nextLine();
	        	 }
	         statement.close();
	        System.out.println("Statement has closed");
	         connection.close();
	         System.out.println("Connection has closed");
		} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
		}
	}
}
