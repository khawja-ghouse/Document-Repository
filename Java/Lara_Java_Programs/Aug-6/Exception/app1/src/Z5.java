import java.util.Scanner;//JDK1.5
class Z5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter something???????????? ");
		String s1 = sc.next();
		try
		{
		System.out.println("1");
		int i = Integer.parseInt(s1);
		System.out.println("2");
		int k =i / (i - 9);
		System.out.println("3");
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("4");
			System.out.println("4");
		}	
		catch (ArithmeticException ex1 ) //Throwable
		{
			System.out.println("5");
			System.out.println("5");
			System.out.println("5");
		}
		System.out.println("main end");
	}
}
/*F:\Aug-6\Exception\app1\src>javac -d ../classes Z5.java
Z5.java:22: error: exception ArithmeticException has already been caught
                catch (ArithmeticException ex1 ) //Throwable
                ^
1 error*/