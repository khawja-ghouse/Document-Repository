package pack1;
import java.sql.DriverManager;//class
import java.sql.SQLException;//this two are classes
import java.sql.Connection;
import java.sql.Statement;//this two are interfaces
class  M20
{
	public static void main(String[] args)
	{
		//1.registring driver
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//this driver suld be available in the classpath
		} 
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String un  = "system";
			String pw  = "nadeem";
			//2.Establishing database connection 
			con = DriverManager.getConnection(url,un,pw);
			//3.create statement
			stmt = con.createStatement();//stmt cant exist without con
			//4. compose sql command
			String sql ="INSERT INTO PERSON VALUES(21,'JAISURYA',35)";
			//5.TRIGGERING SQL COMMAND
			stmt.execute(sql);
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
				if (stmt != null)
				{
					stmt.close();
					stmt = null;
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
