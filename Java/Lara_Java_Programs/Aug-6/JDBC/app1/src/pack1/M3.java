package pack1;
import java.sql.*;
class  M3
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//specifing the driver class name ,REGISTER a driver class
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		//Establish a connection => to were connection should be established  to localhost
		//there are two types of driver thin and Cli(call level interface or called thick driver)
		//jdbc protocol and oracle subprotocol
		Statement  stmt = con.createStatement();
		//String sql1 ="DROP TABLE PERSON CASCADE CONSTRAINTS";
		String sql2 ="CREATE TABLE PERSON (ID NUMBER ,"+" NAME VARCHAR2(90),AGE NUMBER)";
		//stmt.execute(sql1);
		stmt.execute(sql2);
		System.out.println("done");
	}
}
//get connection required 3 arguments
//1->URL
//2->System(username)
//3->great123(password)

//D:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc5.jar;
//D:\Tomcat 8.5\lib\servlet-api.jar;.;D:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc5.jar;