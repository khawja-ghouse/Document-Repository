class Z
{
	public static void main(String[] args) 
	{	
		System.out.println("main1");
		test();
		System.out.println("main2");
	}
	public static int test()
	{
		System.out.println("from test");
		return 1000;
	}	
}