class  C3
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
		}
		return 40;
	}
}
