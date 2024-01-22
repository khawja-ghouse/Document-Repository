class Z12
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		try
		{
		System.out.println("1");
		System.exit(0);
		System.out.println("2");
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("3");
		}	
		finally
		{
			System.out.println("from final");
		}
		System.out.println("main end");
	}
}