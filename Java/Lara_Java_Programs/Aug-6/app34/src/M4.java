class  A
{
	static  final void test1()
	{
	}
	static void test2()
	{
	}
}
class  B extends A
{
	static void test1()//CTE bec v are trying to re develop a test1()
	{
	}
	static void test2()//member of B class 
	{
	}
}
class M4
{
	public static void main(String[] args)
	{
		System.out.println("hello");
	}
}