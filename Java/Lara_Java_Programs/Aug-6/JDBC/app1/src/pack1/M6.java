package pack1;
import java.sql.*;
import java.util.Scanner;
class  M6
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		String id = sc.next();			
		System.out.println("Enter the name:");
		String name = sc.next();	
		System.out.println("Enter the age:");
		String age = sc.next();		
		String sql = 

		"INSERT INTO PERSON VALUES("+id+ ",'"+name + "',"+ age +")";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name ,REGISTER a driver class
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement  stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)
