class Z11
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		if(true)
		{
			return;
		}
		try
		{
		System.out.println("1");
		int i = 10/0;
		System.out.println("2");
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("3");
			return;
		}	
		finally
		{
			System.out.println("from final");
		}
		System.out.println("main end");
	}
}