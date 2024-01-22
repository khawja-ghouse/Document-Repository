import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class M4 
{
	public static void main(String args[])
	{
		File f1 = new File("test5.txt");
		try(FileWriter fout = new FileWriter(f1);
		BufferedWriter bout = new BufferedWriter(fout))
		{
		bout.write("hello world");
		bout.write("hello world");
		bout.write("hello world");
		bout.newLine();
		bout.write("hello world");
		System.out.println("done");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}

}
