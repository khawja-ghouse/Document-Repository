

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class M16 
{
	public static void main(String[] args) throws Exception
	{
		F f1 = new F();
		f1.i = 10;
		FileOutputStream fout = new FileOutputStream("test3.ser");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(f1);
		System.out.println("done");
		
	}

}
