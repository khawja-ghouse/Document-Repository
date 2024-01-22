package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M45
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P6(?) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.setInt(1,26);
			cstmt.registerOutParameter(1,Types.1);
			cstmt.execute();
			int price = cstmt.getInt(1);
			System.out.println(price);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
/*


CREATE OR REPLACE PROCEDURE P5 (ARG1 IN OUT NUMBER) AS BEGIN
SELECT AGE INTO ARG1 FROM PERSON WHERE ID = ARG1;
END;