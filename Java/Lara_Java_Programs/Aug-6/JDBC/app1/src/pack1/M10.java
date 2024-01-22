package pack1;
import java.sql.*;
class  M10
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
				"DELETE FROM PERSON WHERE ID = 6";
		stmt.execute(sql);
		System.out.println("done");
	}
}
