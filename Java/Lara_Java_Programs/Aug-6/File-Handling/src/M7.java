import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class M7 
{
	public static void main(String[] args)
	{
		//File f1 = new File("test2.txt");
		FileReader fin = null;
		BufferedReader bin = null;
		try
		{
			fin = new FileReader("test2.txt");
			bin = new BufferedReader(fin);
			String s1;
			while((s1 = bin.readLine()) != null)
			{
				System.out.println(s1);
			}
			System.out.println("done");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(bin != null)
			{
				try
				{
					bin.close();
					bin = null;
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
				try
				{
					fin.close();
					fin = null;
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}	
	}
}
