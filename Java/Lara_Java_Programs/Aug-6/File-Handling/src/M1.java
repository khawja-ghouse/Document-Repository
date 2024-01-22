import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class M1 
{
	public static void main(String args[]) throws IOException
	{
		//File f1 = new File("test1.txt");
		FileWriter fout = new FileWriter("test2.txt");
		fout.write("hello \n world");
		fout.write("hello world");
		fout.write("hello world");
		fout.write("hello world");
		fout.flush();
		fout.close();
		System.out.println("done");		
	}
}
//wrire method is used
