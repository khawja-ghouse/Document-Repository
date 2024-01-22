class C
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		try
		{
			test();	//propagated exception can be handlled at the caller method ducked,delegate,propageted all are same
		}
		catch (ArithmeticException  ex)
		{
			System.out.println("ex");
		}
		
		System.out.println(2);
	}
public static void test()
{
	System.out.println(3);
	int i = 10 / 0;
	System.out.println(4);
}
}
/*
1
3
ex
2
*/