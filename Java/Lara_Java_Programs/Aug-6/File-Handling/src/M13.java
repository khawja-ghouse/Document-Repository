import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class M13 {
	public static void main(String[] args) throws IOException , ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("employee.txt");
		ObjectInputStream in = new ObjectInputStream(fin);
		Employee e1 = (Employee) in.readObject();
		System.out.println(e1.age);
		System.out.println(e1.weight);
		System.out.println(e1.address.streetName);
		System.out.println(e1.email);
		
	}

}
