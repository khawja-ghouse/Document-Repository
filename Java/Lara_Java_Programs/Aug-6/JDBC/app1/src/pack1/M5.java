package pack1;
import java.sql.*;
class  M5
{
	public static void main(String[] args) throws Exception
	{
		if (args.length < 3)
		{
			System.out.println("pls supply 3 command line arguments");
			return;
		}
		String id = args[0];
		String name = args[1];
		String age = args[2];
		String sql = 

		"INSERT INTO PERSON VALUES("+id+ ",'"+name + "',"+ age +")";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name ,REGISTER a driver class
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)
