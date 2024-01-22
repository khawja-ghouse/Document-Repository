class  C5
{
	int test()
	{
		try
		{
			//
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
// in try if there is an exception  the value of return 10 is replaced with  return 40 