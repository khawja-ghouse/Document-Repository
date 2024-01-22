class I
{
	public static void main(String[] args) 
	{	int i =10;
		System.out.println("main1"+i);
		test();
		System.out.println("main2"+i);
	}
	public static void test()
	{
		int i = 20;
		System.out.println("from test"+i);
	}	
}
