import java.util.Scanner;
class E
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter yous age ");
		int age = sc.nextInt();
		if (age <= 0)
		{
			
			throw new ArithmeticException(" age should  be > 0");
		}
		System.out.println("continue.........");
	}
}
/* 
F:\Aug-6\Exception\app5\src>java -cp ../classes E
enter yous age
22
continue.........

F:\Aug-6\Exception\app5\src>java -cp ../classes E
enter yous age
-22
Exception in thread "main" java.lang.ArithmeticException:  age should  be > 0
        at E.main(E.java:12)


		every exception is having 2 constructor 
		1st no arg constructor 
		2nd constructor that accepts string

*/