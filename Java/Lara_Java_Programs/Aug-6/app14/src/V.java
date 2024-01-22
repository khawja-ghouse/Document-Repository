class V
{
	public static void main(String[] args) 
	{	
		System.out.println("main1");
		test();
		System.out.println("main2");
	}
	public static void test()
	{
		System.out.println("from test begin");
		if (true)
		{
			System.out.println(" if block from test ");
			return;
		}
		System.out.println("from test end");
	}	
}
