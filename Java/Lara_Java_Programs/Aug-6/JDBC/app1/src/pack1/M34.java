package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class  M34
{
	public static void main(String[] args) 
	{
		String sql = "INSERT INTO BOOK1 VALUES(?,?,?,?)";
		try(Connection con = Util.getConnection();
		PreparedStatement pstmt = con.prepareCall(sql))
		{
			pstmt.setInt(1,650);
			pstmt.setString(2,"Angular");
			pstmt.setString(3,"Manu");
			pstmt.setInt(4,650);
			pstmt.executeUpdate();
			pstmt.setInt(1,652);
			pstmt.setString(2,"Core java");
			pstmt.setString(3,"vijay");
			pstmt.setInt(4,500);
			pstmt.executeUpdate();
			pstmt.setInt(1,650);
			pstmt.setString(2,"Servlet");
			pstmt.setString(3,"kiran");
			pstmt.setInt(4,750);
			pstmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}