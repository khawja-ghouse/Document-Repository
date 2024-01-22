class G
{
	static int i = test();
	static
	{
		System.out.println("SIB1");
	}
	public static int test()
	{
		System.out.println("test");
		return 10;
	}
	public static void main(String[] args) 
	{
		System.out.println("main");
	}	
	static
	{
		System.out.println("SIB2");
	}

}
