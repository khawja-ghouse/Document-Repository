package pack1;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
class  M19
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","nadeem");
		Statement  stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter table name");
		String tableName = sc.next();
		String sql ="SELECT * FROM "+tableName;
		ResultSet rs  = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		for (int i= 1;i <= cols ;i++ )
		{
			System.out.println(rsmd.getColumnName(i)+"\t");
		}

		while (rs.next())//BASED ON METHOD RETURN VALIUE
		{
			for (int i = 1;i <= cols ;i++ )//BASED ON NO OF COLUMN COUNT
			{
				System.out.print(rs.getString(i)+",");

			}System.out.println();
		}
		System.out.println("done");
	}
}
