package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class  M36
{
	public static void main(String[] args) 
	{
		String sql = "SELECT * FROM BOOK1 WHERE ID > ?";
		try(Connection con = Util.getConnection();
		PreparedStatement pstmt = con.prepareCall(sql))
		{
			pstmt.setInt(1,200);
			ResultSet rs  = pstmt.executeQuery();
			while (rs.next())
			{
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.println();
			}		
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}