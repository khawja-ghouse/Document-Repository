class U
{
	static void test()
	{
		System.out.println("from test()!");
	}
	static void test(int i)
	{
		System.out.println("from test(int i)!");
	}
	static void test(double i)
	{
		System.out.println("from test()!");
	}
	public static void main(String[] args)
	{
		test();
		System.out.println("..................");
		test(20);
		System.out.println("..................");	
		test(20.2);
		System.out.println("..................");
	}
}

//overloading = same names of method but difference in no of arguments or datatype of the arguments