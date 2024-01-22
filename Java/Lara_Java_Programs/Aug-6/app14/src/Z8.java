class Z8
{
	public static void main(String[] args) 
	{	
		System.out.println("main begin");
		int i = 10 + test();
		System.out.println("main end");
	}
	public static int test()
	{
		System.out.println("from test");
	}	
}