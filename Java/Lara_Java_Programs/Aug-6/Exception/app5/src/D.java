import java.util.Scanner;
class D
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter yous age ");
		int age = sc.nextInt();
		if (age <= 0)
		{	
			throw new ArithmeticException("");
		}
		System.out.println("continue.........");
	}
}
/* 
:\Aug-6\Exception\app5\src>java -cp ../classes D
enter yous age
22
continue.........

F:\Aug-6\Exception\app5\src>java -cp ../classes D
enter yous age
0
Exception in thread "main" java.lang.ArithmeticException:
        at D.main(D.java:12)

*/