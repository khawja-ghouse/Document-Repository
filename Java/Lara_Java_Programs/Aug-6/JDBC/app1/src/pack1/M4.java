package pack1;
import java.sql.*;
class  M4
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name ,REGISTER a driver class
		Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement  stmt = con.createStatement();
		String sql1 ="INSERT INTO PERSON VALUES(1,'ABC',22)";
		String sql2 ="INSERT INTO PERSON VALUES(2,'DEF',23)";
		String sql3 ="INSERT INTO PERSON VALUES(3,'GHI',24)";
		String sql4 ="INSERT INTO PERSON VALUES(4,'JKL',25)";
		String sql5 ="INSERT INTO PERSON VALUES(5,'MON',26)";
		String sql6 ="INSERT INTO PERSON VALUES(6,'PQR',27)";
		String sql7 ="INSERT INTO PERSON VALUES(7,'STU',28)";
		stmt.execute(sql1);
		stmt.execute(sql2);
		stmt.execute(sql3);
		stmt.execute(sql4);
		stmt.execute(sql5);
		stmt.execute(sql6);
		stmt.execute(sql7);
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)
