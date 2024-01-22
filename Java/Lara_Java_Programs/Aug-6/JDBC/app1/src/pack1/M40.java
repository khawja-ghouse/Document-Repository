package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M40
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P3(901,'HADOOP','MURALI',3000) }";
		try(Connection con = Util.getConnection();
		CallableStatement cstmt = con.prepareCall(sql))
		{
			cstmt.execute(sql);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
/*


CREATE OR REPLACE PROCEDURE P2 (ARG1 NUMBER,
								ARG2 VARCHAR2,
								ARG3 VARCHAR2,
								ARG4 NUMBER) AS BEGIN
INSERT INTO BOOK  VALUES(ARG1,ARG2,ARG3,ARG4);
END;

SELECT * FROM PERSON;
SELECT * FROM BOOK;
*/