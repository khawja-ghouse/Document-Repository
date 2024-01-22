class  C7
{
	int test()
	{
		try
		{
			//
		}
		catch(ArithmeticException ex)
		{
			
		}
		finally
		{
			return 40;
		}
		return 10;		
	}
}
//every flow going to the finally there v have a return 40 hence return 10 become unreachable statement