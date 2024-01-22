package pack1;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
class  M26
{
	public static void main(String[] args) 
	{
		String sql = "INSERT INTO BOOK1 VALUES(2,'J2EE','KHAWJA',1000)";
		try(Connection con = Util.getConnection();
		Statement stmt = con.createStatement())
		{
			int i = stmt.executeUpdate(sql);
			System.out.println(i);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("done");
	}
}
//execute()  used for DDL and DML 
//fro DML use executeupdate() method 
//execute() method return type is boolean
//executeUpdate() return type is int used for DML