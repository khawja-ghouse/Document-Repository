package pack1;
import java.sql.*;
import java.io.*;
class  M15
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
			System.out.print(rs.getString(1) + ",");
			System.out.print(rs.getString(2) + ",");
			System.out.println();
		}

		System.out.println("done");
	}
}
