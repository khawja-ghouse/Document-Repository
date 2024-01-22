class K
{
	static int x = test();
	static
	{
		System.out.println("SIB1" + x);
		x  += 1;
		main(null);
		System.out.println("SIB1" + x);
	}
	public static int test()
	{
		System.out.println("from test:" + x);
		x += 2;
		main(null);
		System.out.println("from test" + x);
		return x + 3;
	}
	public static void main(String[] args) 
	{
		System.out.println("main:" + x);
		x += 4;
	}	

}
