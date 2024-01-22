class J
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		char c1 = test();
		System.out.println("main end ->" + c1);
	}
	public static char test()
	{
		System.out.println("from test");
		return 65;
	}
}
