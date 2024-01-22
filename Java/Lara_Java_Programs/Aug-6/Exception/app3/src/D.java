class D
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		try
		{
			test1();
		}
		catch (ArithmeticException  ex)
		{
			System.out.println("ex");
		}
		System.out.println(2);
	}
	public static void test1()
	{
	System.out.println(3);
	test2();
	System.out.println(4);
	}
	public static void test2()
    {
	System.out.println(5);
	int i = 10 / 0;
	System.out.println(6);
    }
}
/*
1
3
5
ex
2
*/