package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCompany {



	

	public static void main(String[] args) {
		
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("1. load and register is completed");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
	            System.out.println("2. connection has established");
	            Statement statement = connection.createStatement(); 
	            System.out.println("3. Platform has created");

	            Scanner scanner = new Scanner(System.in);

	            // Scenario 1: Successful Signup
	            System.out.println("SignUp process");
	            System.out.println("Enter your id");
	            String id = scanner.nextLine();
	            
	            System.out.print("Enter your  Name: ");
	            String Name = scanner.nextLine();
	            
	            
	            System.out.print("Enter your designation: ");
	            String designation = scanner.nextLine();

	            System.out.print("Enter your email: ");
	           String email = scanner.nextLine();

	            // Validate email format
	           if (!email.contains("@")) {
	                System.out.println("Registration unsuccessful, please enter a correct email address");
	                connection.close();
	                return;
	            }
	           
	            

	            System.out.print("Enter your phone number: ");
	            String phone = scanner.nextLine();

	            // Validate phone number length
	            if (phone.length() != 10 || !phone.matches("\\d+")) {
	                System.out.println("Registration unsuccessful, phone number must be 10 digits");
	                connection.close();
	                return;
	            }
	            
	            

	            // Insert user data into the database
	          String insertQuery = ("INSERT INTO employeedb VALUES (?, ?, ?, ?,?)");
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, Name);
	            preparedStatement.setString(3, designation);
	           preparedStatement.setString(4, email );
	            preparedStatement.setString(5, phone);

	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	            	
	                System.out.println("Registration successful");
	            } else {
	                System.out.println("Registration unsuccessful, please try again later");
	            }
		 
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    } 
	}
	    
	            
	          