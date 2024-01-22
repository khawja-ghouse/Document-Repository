package pack1;
import java.sql.*;
import java.io.*;
class  M8
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"system","nadeem");
		Statement  stmt = con.createStatement();
		FileReader fin  = new FileReader("data.txt");
		BufferedReader bin = new BufferedReader(fin);
		String record = bin.readLine();//reads the first line 
		String id,name,age,sql,data[];
		while (record != null)
		{
			data = record.split(";");
			id = data[0].trim();
			name = data[1].trim();
			age = data[2].trim();
			sql =
				"INSERT INTO PERSON VALUES("+id+ ",'"+name + "',"+ age +")";
		stmt.execute(sql);
		record = bin.readLine();
		}
		System.out.println("done");
	}
}
