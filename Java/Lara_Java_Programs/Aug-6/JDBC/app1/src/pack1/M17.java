package pack1;
import java.sql.*;
import java.io.*;
class  M17
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","nadeem");
		Statement  stmt = con.createStatement();
		String sql ="SELECT id p_id, age person_age FROM PERSON";
		ResultSet rs  = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnName(2));

		while (rs.next())
		{
			System.out.print(rs.getString("p_id") + ",");
			System.out.print(rs.getString("person_age") + ",");
			System.out.println();
		}
		System.out.println("done");
	}
}
