package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M41
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P3(?,?,?,?) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.setInt(1,902);
			cstmt.setString(2,"html");
			cstmt.setString(3,"khawja");
			cstmt.setInt(4,3500);
			cstmt.execute();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}