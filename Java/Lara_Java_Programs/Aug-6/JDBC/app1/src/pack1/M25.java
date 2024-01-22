package pack1;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
class  M25
{
	public static void main(String[] args) 
	{
		String sql = "INSERT INTO BOOK1 VALUES(1,'JAVA','NADEEM',600)";
		try(Connection con = Util.getConnection();
		Statement stmt = con.createStatement())
		{
			stmt.execute(sql);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
