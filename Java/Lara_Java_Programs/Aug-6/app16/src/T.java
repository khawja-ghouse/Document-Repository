class T
{
	static int i = test();
	public static int test()
	{
		System.out.println("from test:" + i );
		return 10;
	}
	public static void main(String[] args) 
	{
		System.out.println("main1:"+i);
	}
}
