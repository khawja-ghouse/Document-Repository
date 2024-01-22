package pack1;
import java.sql.*;
import java.util.Scanner;
class  M7
{
	public static void main(String[] args) throws Exception
	{
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name ,REGISTER a driver class
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement  stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		String id , name, age, sql;
		do
		{
		System.out.print("Enter the id:");
		 id = sc.next();			
		System.out.print("Enter the name:");
		 name = sc.next();	
		System.out.print("Enter the age:");
		 age = sc.next();		
		 sql = 
		"INSERT INTO PERSON VALUES("+id+ ",'"+name + "',"+ age +")";
		stmt.execute(sql);
		System.out.println("do you want to insert one more(yes/no)?");
		}
		while ("yes".equalsIgnoreCase(sc.next()));
		
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)
