import java.util.Scanner;
class G
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter yous age ");
		int age = sc.nextInt();
		if (age <= 0)
		{
			
			throw new AgeIsNegativeException();
		}
		System.out.println("continue.........");
	}
}
/* 
F:\Aug-6\Exception\app5\src>java -cp ../classes G
enter yous age
0
Exception in thread "main" AgeIsNegativeException
        at G.main(G.java:12)
*/