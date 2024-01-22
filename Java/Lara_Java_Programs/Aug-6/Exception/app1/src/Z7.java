import java.util.Scanner;//JDK1.5
class Z7
{
	public static void main(String[] args) 
	{
		System.out.println("enter something ? ");
		try
		{
			System.out.println("1");
			int i = 10/0;
			System.out.println("2");
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("3");
			int i = 10/0;
			System.out.println("4");

		}	
		finally
		{
			System.out.println("from final");
		}
		System.out.println("main end");
	}
}
/*

*/