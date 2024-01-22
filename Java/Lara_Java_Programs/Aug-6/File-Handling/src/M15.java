import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class M15 
{
	public static void main(String[] args) throws Exception
	{
		E e1 = new E();
		e1.i = 1;
		e1.j = 2;
		FileOutputStream  fout = new FileOutputStream("test2.ser");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(e1);
		out.flush();
		out.close();
		System.out.println("------------------------");
		
		FileInputStream fin = new FileInputStream("test2.ser");
		ObjectInputStream in = new ObjectInputStream(fin); 
		E e2 = (E) in.readObject();
		System.out.println(e2.i);
		System.out.println(e2.j);
		
	}

}
