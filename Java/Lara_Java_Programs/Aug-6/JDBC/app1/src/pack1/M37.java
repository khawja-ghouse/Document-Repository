package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class  M37
{
	public static void main(String[] args) 
	{
		String sql = "CREATE TABLE BOOK2(SNO NUMBER)";
		try(Connection con = Util.getConnection();
		PreparedStatement pstmt = con.prepareCall(sql))
		{
			pstmt.execute(sql);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}