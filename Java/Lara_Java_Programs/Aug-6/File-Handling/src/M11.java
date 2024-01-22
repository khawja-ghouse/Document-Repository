import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class M11 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("person.txt");
		ObjectInputStream in = new ObjectInputStream(fin);
		Person p1 = (Person) in.readObject();
		System.out.println(p1.age);
		System.out.println(p1.weight);
		System.out.println(p1.address.streetName);	
	}
}
