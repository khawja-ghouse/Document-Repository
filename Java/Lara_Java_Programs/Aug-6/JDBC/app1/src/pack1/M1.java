package pack1;
import java.sql.*;
class  M1
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","nadeem");
		Statement  stmt = con.createStatement();
		String sql = "CREATE TABLE TEST1(SNO NUMBER,NAME VARCHAR(90),AGE NUMBER)";
		stmt.execute(sql);
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)
//D:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc5.jar;
//D:\Tomcat 8.5\lib\servlet-api.jar;.;D:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc5.jar;