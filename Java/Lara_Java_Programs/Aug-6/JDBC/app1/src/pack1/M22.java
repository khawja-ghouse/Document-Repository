package pack1;
import java.sql.DriverManager;//
import java.sql.SQLException;//this two are classes
import java.sql.Connection;
import java.sql.Statement;//this two are interfaces
import java.sql.ResultSet;//
import java.sql.ResultSetMetaData;//
class  M21
{
	public static void main(String[] args)
	{
		//1.registring driver
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//this driver suld be available in the classpath
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String un = "system";
		String pw = "nadeem";
		String sql ="SELECT * FROM PERSON";
		try(Connection con = DriverManager.getConnection(url,un,pw);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql))//JDK 1.7(auto resource closing)
		{			
			ResultSetMetaData  rsmd = rs.getMetaData();//is not a resource 
			int cols = rsmd.getColumnCount();
			for (int i = 1;i <= cols ;i++ )
			{
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("===========================");
			while (rs.next())//BASED ON METHOD RETURN VALIUE
			{
				for (int i = 1;i <= cols ;i++ )//BASED ON NO OF COLUMN COUNT
				{
					System.out.print(rs.getString(i)+",");

				}System.out.println();
			}
			System.out.println("done");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
