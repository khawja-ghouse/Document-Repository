class P
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
			System.out.println(1);
			int i = 10 /0;
			System.out.println(2);
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println(ex);
		}
		System.out.println("main end");
	}
}
