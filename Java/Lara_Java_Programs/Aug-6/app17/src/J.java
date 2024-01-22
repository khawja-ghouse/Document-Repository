class J
{
	static int x = test();
	static
	{
		System.out.println("SIB1" + x);
	}
	public static int test()
	{
		System.out.println("test:" + x);
		return 100;
	}
	public static void main(String[] args) 
	{
		System.out.println("main:" + x);
	}	

}
