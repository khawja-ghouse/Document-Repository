package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M44
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P5(?,?,?) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.setInt(1,2);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.execute();
			String title = cstmt.getString(2);
			String author = cstmt.getString(3);
			System.out.println(title+","+author);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
/*


CREATE OR REPLACE PROCEDURE P5 (ARG1 NUMBER,
								ARG2 OUT VARCHAR,
								ARG3 OUT VARCHAR) AS BEGIN
SELECT TITLE INTO ARG2 FROM BOOK WHERE ID = ARG1;
SELECT AUTHOR INTO ARG3 FROM BOOK WHERE ID = ARG1;
END;