package pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
class  M38
{
	public static void main(String[] args) 
	{
		String sql = "{ CALL P1 }";
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



DROP TABLE PERSON CASCADE CONSTRAINTS;

CREATE TABLE PERSON(ID NUMBER,FIRST_NAME VARCHAR2(10),AGE NUMBER);

DROP TABLE BOOK CASCADE CONSTRAINTS;
CREATE TABLE BOOK (ID NUMBER,TITLE VARCHAR2(20), AUTHOR VARCHAR2(10),PRICE NUMBER);

CREATE OR REPLACE PROCEDURE P1 AS BEGIN

INSERT INTO PERSON VALUES(2001,''ABC',22);
INSERT INTO PERSON VALUES(2002,''XYZ',23);
INSERT INTO PERSON VALUES(2001,''TEST',25);
INSERT INTO BOOK  VALUES(3001,''JAVA MADE EASY','VIJAY',500);
INSERT INTO BOOK  VALUES(3002,''J2EE MADE EASY','VIJAY',600);
INSERT INTO BOOK  VALUES(3003,''ANGULAR MADE EASY','VIJAY',300);
END;

SELECT * FROM PERSON;
SELECT * FROM BOOK;
*/