package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M43
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P4(?,?) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.setInt(1,2002);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.execute();
			String s1 = cstmt.getString(2);
			System.out.println(s1);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
/*


CREATE OR REPLACE PROCEDURE P4 (ARG1 NUMBER,
								ARG2 OUT VARCHAR2) AS BEGIN
SELECT FIRST_NAME INTO ARG2 FROM PERSON WHERE ID = ARG1;
END;

IN(DEFALUT)
OUT
IN OUT
*/