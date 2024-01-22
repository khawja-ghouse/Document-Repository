import java.io.IOException;
import java.io.PrintStream;

public class M20 
{
	public static void main(String[] args) throws IOException
	{
		PrintStream p1 = new PrintStream("test1.log");
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
		p1.println("hello");
	}


}
