class  C4
{
	int test()
	{
		try
		{
			return 20;
		}
		catch(ArithmeticException ex)
		{
			return 10;
		}
		finally
		{
			return 40;
		}
		
	}
}
// in try the value of return 20 is replaced with  return 40 