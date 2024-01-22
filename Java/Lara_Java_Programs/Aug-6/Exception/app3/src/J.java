class J
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		test();
		System.out.println(2);
	}
	public static void test()
	{
	System.out.println(3);
	try
	{
		Class.forName("");
	}
	catch (ClassNotFoundException ex)
	{
		System.out.println("ex");
	}
	System.out.println(4);
	}
}
/*
1
3
ex
4
2
*/