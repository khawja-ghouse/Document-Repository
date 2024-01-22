import java.io.IOException;
import java.io.PrintStream;

public class M21 
{
	public static void main(String[] args) throws IOException
	{
		PrintStream p1 = new PrintStream("test2.log");
		System.setOut(p1);
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
	}

}
