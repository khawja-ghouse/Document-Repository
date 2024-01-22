class C
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
	boolean test(boolean i)
	{
		System.out.println("test(boolean i)");
		return false;
	} 

}
//overloaded method can have any access specfiers
//same method with different signature==>overloading
//even the return type of the method can be different for overloaded methods