import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class M14 
{
	public static void main(String[] args) throws Exception
	{
		D d1 = new D();
		d1.i = 1;
		d1.j = 2;
		d1.k = 3;
		d1.l = 4;
		FileOutputStream  fout = new FileOutputStream("test1.ser");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(d1);
		out.flush();
		out.close();
		System.out.println("------------------------");
		
		FileInputStream fin = new FileInputStream("test1.ser");
		ObjectInputStream in = new ObjectInputStream(fin); 
		D d2 = (D) in.readObject();
		System.out.println(d2.i);
		System.out.println(d2.j);
		System.out.println(d2.k);
		System.out.println(d2.l);
	}
}
