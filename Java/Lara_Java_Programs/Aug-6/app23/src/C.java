class E
{
	static int i;
	static void test1()
	{
		System.out.println("E-test1()");
	}

}
class F extends E
{

	static int j;
	static void test2()
	{
		System.out.println("F-test()");
	}
	public static void main(String[] args) 
	{
		System.out.println(F.i);
		System.out.println(F.j);
		F.test1();
		F.test2();
	}
}
