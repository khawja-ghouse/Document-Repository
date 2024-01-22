package pack1;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
class  Util
{
	public static Connection getConnection() throws SQLException
	{
		Properties pr = new Properties();
		try(FileReader fin = new FileReader("db.properties"))
		{
			pr.load(fin);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		String driver =pr.getProperty("driverClassName");
		String url =pr.getProperty("url");
		String un =pr.getProperty("username");
		String pw =pr.getProperty("password");
		//1.registring driver
		try
		{
			Class.forName(driver);//this driver suld be available in the classpath
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url,un,pw);
		System.out.println("Con:"+con);
		return con;
	}
}
