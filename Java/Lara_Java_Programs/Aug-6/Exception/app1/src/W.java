class W
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
			i =20;
		}
		System.out.println("main end"+i);
	}
}
/*
W.java:13: error: cannot find symbol
                        i =20;
                        ^
  symbol:   variable i
  location: class W
W.java:15: error: cannot find symbol
                System.out.println("main end"+i);
                                              ^
  symbol:   variable i
  location: class W
2 errors
*/