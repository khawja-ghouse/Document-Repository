package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M42
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P3(?,?,?,?) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.setInt(1,902);
			cstmt.setInt(2,"html");
			cstmt.setInt(3,"khawja");
			cstmt.setInt(4,3500);
			cstmt.execute();
			cstmt.setInt(1,903);
			cstmt.setInt(2,"css");
			cstmt.setInt(3,"nadeem");
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