class Z14
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		try
		{
		System.out.println("1");
		int i = 10 /0 ;
		System.out.println("2");
		}
		finally
		{
			System.out.println("from final");
		}	
		System.out.println("main end");
	}
}
//if you are not providing any catches then finally is mandatory;
//in this program there is no exception handling
/*
try-catch;
try-catch-finally;
try-catchs;
try-catchs-finally;
try-finally;
finally block should be a last block in try-catch-finally
we cant use only catch ,only try,only finally;
*/
