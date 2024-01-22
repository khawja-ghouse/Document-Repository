import java.util.Scanner;
class F
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter yous age ");
		int age = sc.nextInt();
		if (age <= 0)
		{
			
			throw new AgeIsNegativeException("Age shu not be  > 0");
		}
		System.out.println("continue.........");
	}
}
/* 

F:\Aug-6\Exception\app5\src>javac -d ../classes F.java

F:\Aug-6\Exception\app5\src>java -cp ../classes F
enter yous age
-22
Exception in thread "main" AgeIsNegativeException: Age shu not be  > 0
        at F.main(F.java:12)

*/