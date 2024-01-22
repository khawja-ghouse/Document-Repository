package pack1;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
class  M28
{
	public static void main(String[] args) 
	{
		String sql1 = "INSERT INTO BOOK1 VALUES(6,'SPRINGS','MANU',4000)";
		String sql2 = "INSERT INTO BOOK1 VALUES(7,'HIBERNET','AFRID',900)";
		String sql3 = "INSERT INTO BOOK1 VALUES(8, HADOOP','KHADIR',1000)";
		try(Connection con = Util.getConnection();
		Statement stmt = con.createStatement())
		{		
			stmt.executeUpdate(sql1);
			System.out.println("sql1 is updated");			
			stmt.executeUpdate(sql2);
			System.out.println("sql2 is updated");
			stmt.executeUpdate(sql3);
			System.out.println("sql3 is updated");
			System.out.println();
				
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}