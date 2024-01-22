package pack1;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
class  M30
{
	public static void main(String[] args) 
	{
		String sql1 = "INSERT INTO BOOK1 VALUES(30,'SPRINGS','MANU',4000)";
		String sql2 = "INSERT INTO BOOK1 VALUES(40,'HIBERNET','AFRID',900)";
		String sql3 = "INSERT INTO BOOK1 VALUES(50, 'HADOOP','KHADIR',1000)";
		Connection con = null;
		try
		{
			con = Util.getConnection();
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);//before executing any sql command ;boundary of the transaction
			//dont commit sql command => at last if all the query are succfully executed then commit at last
			stmt.executeUpdate(sql1);
			System.out.println("sql1 is updated");			
			stmt.executeUpdate(sql2);
			System.out.println("sql2 is updated");
			stmt.executeUpdate(sql3);//exception goes to the catch block
			System.out.println("sql3 is updated");
			con.commit();	//boundary of the transaction			
		}
		catch (SQLException ex)
		{
			try
			{
				con.rollback();
			}
			catch (SQLException ex1)
			{
			ex1.printStackTrace();
			}
		}
		System.out.println("done");
	}
}