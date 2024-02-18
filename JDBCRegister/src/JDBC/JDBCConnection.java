package JDBC;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Properties;
public class JDBCConnection {

	public static void main(String[] args) {

	try{
         Class.forName("com.mysql.cj.jdbc.Driver");//passing qualify name of Driver class
         System.out.println("1. load and register is completed");
     //    DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2?user=root&password=roothaider62586@");
         
         FileReader reader = new  FileReader("resource\\db.properties");
         Properties pr = new Properties();
         pr.load(reader);
         
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajrb2",pr);
         
         System.out.println("2. connection has established"); 
         Statement statement = con.createStatement();  
         System.out.println("3. Platform has created");
       
       //statement.exe     //statement.execute("INSERT INTO student VALUES (104, 'Jyoti', 'BCA')");cute("INSERT INTO student VALUES (103, 'Payal', 'CS')");
    
         ResultSet resultSet = statement.executeQuery("select*from student");
         while(resultSet.next()) {
          System.out.println(resultSet.getInt(1)+""+resultSet.getString(2)+""+resultSet.getString(3));
         }
         
         System.out.println("4. Query has  executed");
        
	} catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
   
    }catch(IOException e) {
    	e.printStackTrace();
    	  
    }
   }
}





