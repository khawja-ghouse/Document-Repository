import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class M10 
{
	public static void main(String[] args) throws IOException
	{
		Address add = new Address();
		add.streetName = "BTM";
		Person p1 = new Person();
		p1.age = 25;
		p1.weight = 57.5;
		p1.address = add;
		
		FileOutputStream fout = new FileOutputStream("person.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(p1);
		out.flush();
		System.out.println("done");
	}
}
