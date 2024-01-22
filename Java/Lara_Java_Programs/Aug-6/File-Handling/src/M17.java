import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class M17 
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fin = new FileInputStream("test3.ser");
		ObjectInputStream in = new ObjectInputStream(fin);
		F f1 = (F) in.readObject();
		System.out.println(f1.i);
		System.out.println(f1.j);
		
	}

}
