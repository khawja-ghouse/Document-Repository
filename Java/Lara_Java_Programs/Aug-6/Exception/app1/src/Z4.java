import java.util.Scanner;//JDK1.5
class Z4
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter somethimg ");
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
		}	
		catch (NumberFormatException ex1 ) //Throwable
		{
			System.out.println("5");
		}
		System.out.println("main end");
	}
}
/*F:\Aug-6\Exception\app1\src>java -cp ../classes Z4
enter somethimg
abc
1
5
main end

F:\Aug-6\Exception\app1\src>java -cp ../classes Z4
enter somethimg
5
1
2
3
main end

F:\Aug-6\Exception\app1\src>java -cp ../classes Z4
enter somethimg
18
1
2
3
main end*/