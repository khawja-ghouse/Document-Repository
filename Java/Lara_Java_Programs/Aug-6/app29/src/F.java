abstract class F
{
	public static void test()
	{
		System.out.println("test()");
	}
	final int  test(int i)//even final method can be overloaded
	{
		System.out.println("test(int i)");
		return 20;
	}
	abstract boolean test(double i);

}