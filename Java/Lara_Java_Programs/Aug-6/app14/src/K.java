class K
{
	public static void main(String[] args) 
	{
		System.out.println("main1:");
		test1();
		System.out.println("main2");
		test2();
		System.out.println("main3:");
	}
	public static void test1()//method defination
	{
		
		System.out.println("from test1 begin");
		test2();
		System.out.println("from test1 end");

	}	
	public static void test2()//method defination
	{
		
		System.out.println("from test2");

	}
}
