class  B6
{
	int test()
	{
		try
		{
			return 20;
		}
		catch(ArithmeticException ex)
		{
			return 30;
		}
		return 40;
	}
}
