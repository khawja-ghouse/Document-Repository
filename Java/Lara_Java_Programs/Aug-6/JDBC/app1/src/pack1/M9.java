            package pack1;
import java.sql.*;
import java.io.*;
class  M9
{
	public static void main(String[] args) throws Exception
	{
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement  stmt = con.createStatement();
		String
			sql =
				"UPDATE PERSON SET NAME = 'KHAWJA' WHERE ID = 5";
		stmt.execute(sql);
		System.out.println("done");
	}
}
