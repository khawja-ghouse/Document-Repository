class T
{
	public static void main(String[] args)  
	{
		System.out.println("Main begin");
		try
		{
			test();
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("ex");
		}
		System.out.println("Main end");
	}
	public static void test() throws ClassNotFoundException
	{
		System.out.println("from test");
	}
}
/*

Main begin
from test
Main end
*/