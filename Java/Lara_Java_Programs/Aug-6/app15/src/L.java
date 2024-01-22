class L
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test();//cmp error not passing an arguments
		System.out.println("main end ->");
	}
	public static String  test(int i)
	{
		System.out.println("from test");
	}
}
