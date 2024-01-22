class I
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		boolean b1 = test();
		System.out.println("main end" + b1);
	}
	public static boolean test()
	{
		System.out.println("from test");
		return false;
	}
}
