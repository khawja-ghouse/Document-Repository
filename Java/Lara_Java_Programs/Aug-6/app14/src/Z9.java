class Z9
{
	public static void main(String[] args) 
	{	
		System.out.println("main begin");
		int i = 10 + test();
		System.out.println("main end" + i);
	}
	public static int  test()
	{
		int x = 100;
		System.out.println("from test");
		return x;
	}	
}