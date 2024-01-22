package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M39
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P2 }";
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


CREATE OR REPLACE PROCEDURE P2 AS BEGIN
INSERT INTO PERSON VALUES(2004,''ABC',22);
INSERT INTO PERSON VALUES(2005,''XYZ',23);
INSERT INTO PERSON VALUES(2006,''TEST',25);
INSERT INTO BOOK  VALUES(3004,''JAVA MADE EASY','VIJAY',500);
INSERT INTO BOOK  VALUES(3005,''J2EE MADE EASY','VIJAY',600);
INSERT INTO BOOK  VALUES(3006,''ANGULAR MADE EASY','VIJAY',300);
UPDATE PERSON SET FIRST_NAME = 'VIJAY' WHERE ID = 2002;
END;

SELECT * FROM PERSON;
SELECT * FROM BOOK;
*/