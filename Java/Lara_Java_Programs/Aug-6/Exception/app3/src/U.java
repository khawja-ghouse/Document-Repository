class U
{
	public static void main(String[] args)  throws ClassNotFoundException
	{
		System.out.println("Main begin");
		test();
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