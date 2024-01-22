package pack1;
import java.sql.DriverManager;//
import java.sql.SQLException;//this two are classes
import java.sql.Connection;
import java.sql.Statement;//this two are interfaces
import java.sql.ResultSet;//
import java.sql.ResultSetMetaData;//
class  M21
{
	public static void main(String[] args)
	{
		//1.registring driver
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//this driver suld be available in the classpath
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet  rs = null;//this is one of the resource
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String un = "system";
			String pw = "nadeem";
			//2.Establishing database connection 
			con = DriverManager.getConnection(url,un,pw);
			//3.create statement
			stmt = con.createStatement();//stmt cant exist without con
			//4. compose sql command
			String sql ="SELECT * FROM PERSON";
			//5.TRIGGERING SQL COMMAND
			rs = stmt.executeQuery(sql);
			ResultSetMetaData  rsmd = rs.getMetaData();//is not a resource 
			int cols = rsmd.getColumnCount();
			for (int i = 1;i <= cols ;i++ )
			{
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("===========================");
			while (rs.next())//BASED ON METHOD RETURN VALIUE
			{
				for (int i = 1;i <= cols ;i++ )//BASED ON NO OF COLUMN COUNT
				{
					System.out.print(rs.getString(i)+",");

				}System.out.println();
			}
			System.out.println("done");

		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//6. close datbase resource
			
			try
			{
				if (rs != null)
				{
					rs.close();
					rs =null;
				}
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}

			try
			{
				if (stmt != null)
				{
					stmt.close();
					stmt =null;
				}
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if (con != null)
				{
					con.close();
					con = null;
				}
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}//End of finally
		System.out.println("done");
	}
}
