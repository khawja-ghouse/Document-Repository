class Z1
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
		System.out.println("1");
		int i =10;
		i = 10 / 0;
		System.out.println("2");
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("3");
			try
			{
				System.out.println("4");
				int i = 10/0;
				System.out.println("5");
			}
			catch (ArithmeticException ex1)
			{
				System.out.println("6");
			}
			System.out.println("7");
		}
		System.out.println("main end");
	}
}
/*main begin!
1
3
4
6
7
main end*/