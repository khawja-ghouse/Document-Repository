class S
{
	public static void main(String[] args)  
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

S.java:6: error: unreported exception ClassNotFoundException; must be caught or declared to be thrown
                test();
                    ^
1 error
*/