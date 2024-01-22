class Y
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		int i = 10;
		try
		{
			i = 10 / 0;
		}
		catch (ArithmeticException ex ) //Throwable
		{
			i = 20;
		}
		System.out.println("main end"+i);
	}
}
/*main begin!
main end 20
*/