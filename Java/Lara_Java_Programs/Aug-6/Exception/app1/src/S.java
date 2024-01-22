class S
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
			System.out.println(1);
			int i = 10 /0;
			System.out.println(2);
		}
		catch (NullPointerException ex ) //Throwable
		{
			ex.printStackTrace();
		}
		System.out.println("main end");
	}
}
/*
rised exception is not getting handeled
main begin!
1
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at S.main(S.java:9)
		*/