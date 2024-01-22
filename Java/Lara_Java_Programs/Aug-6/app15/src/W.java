class W
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int x = 10;
		test(x);
		System.out.println("main end ->");
	}
	public static void  test(int i)
	{
		System.out.println("from test:" + i);
	}
}
