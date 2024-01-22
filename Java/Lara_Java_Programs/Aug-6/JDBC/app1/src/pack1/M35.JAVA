package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class  M35
{
	public static void main(String[] args) 
	{
		String sql = "UPDATE BOOK1 SET AUTHOR = ? WHERE ID = ?";
		try(Connection con = Util.getConnection();
		PreparedStatement pstmt = con.prepareCall(sql))
		{
			pstmt.setInt(1,"MANOHAR");
			pstmt.setInt(2,653);
			pstmt.executeUpdate();
			pstmt.setInt(1,"SABIHA");
			pstmt.setInt(2,654);
			pstmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}