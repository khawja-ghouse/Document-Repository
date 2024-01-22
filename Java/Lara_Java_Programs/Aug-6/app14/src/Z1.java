class Z1
{
	public static void main(String[] args) 
	{	
		System.out.println("main1");
		int i = 100 + test();
		System.out.println("main2 " + i);
	}
	public static int test()
	{
		System.out.println("from test");
		return 1000;
	}	
}