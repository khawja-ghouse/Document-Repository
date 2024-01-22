package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class  M31
{
	public static void main(String[] args) 
	{
		String sql = "INSERT INTO BOOK1 VALUES(350,'J2EE','KHAWJA',1000)";
		try(Connection con = Util.getConnection();
		PreparedStatement pstmt = con.prepareCall(sql))
		{
			pstmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
//what ever v do with Ststement same v can do with prepared stmt
//even Prepared stmt is interface
//prepared stmt is extending to the Statement