class X
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
		int i =10;
		i = 10 / 0;
		}
		catch (ArithmeticException ex ) //Throwable
		{
			ex =null;
		}
		System.out.println("main end"+ex);
	}
}
/*ex is local to catch
X.java:15: error: cannot find symbol
                System.out.println("main end"+ex);
                                              ^
  symbol:   variable ex
  location: class X
1 error
*/