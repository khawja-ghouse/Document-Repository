abstract class D
{
	public static void test()
	{
		System.out.println("test()");
	}
	int  test(int i)
	{
		System.out.println("test(int i)");
		return 20;
	}
	abstract boolean test(double i);

}
// in case of method overloading same name different signature 