package pack1;
import java.sql.*;
import java.io.*;
class  M16
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","nadeem");
		Statement  stmt = con.createStatement();
		String sql ="SELECT id p_id, age person_age FROM PERSON";
		ResultSet rs  = stmt.executeQuery(sql);
		while (rs.next())
		{
			System.out.print(rs.getString("p_id") + ",");
			System.out.print(rs.getString("person_age") + ",");
			System.out.println();
		}
		System.out.println("done");
	}
}
