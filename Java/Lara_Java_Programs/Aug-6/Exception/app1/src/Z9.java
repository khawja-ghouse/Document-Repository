
class Z9
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		try
		{
		System.out.println("1");
		return;
		}
		catch (ArithmeticException ex ) //Throwable
		{
			System.out.println("2");
		}	
		finally
		{
			System.out.println("from final");
		}
		System.out.println("main end");
	}
}
/*
enter something ?
1
3
from final
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Z7.main(Z7.java:16)
*/