package pack1;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
class  M24
{
	public static void main(String[] args) 
	{
		String sql = "CREATE TABLE BOOK1 (ID NUMBER,TITLE VARCHAR2(10),AUTHOR VARCHAR(20),PRICE NUMBER)";
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
