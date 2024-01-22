class O 
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
			System.out.println(1);
			int i = 10 /0;//exception object is arithmetic type that shuld be same as the type of the catch exception argument
			System.out.println(2);
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println(3);
		}
		System.out.println("main end");
	}
}
