class A
{
	static
	{
		System.out.println("A.sib");
	}
	void test()
	{
		System.out.println("test");
	}
}
class  M4
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("main begin");
		Class c1 = Class.forName("A");//returns the Class object
		System.out.println("----------");
		System.out.println(c1);
		System.out.println("----------");
		A a1 = new A();
		a1.test();
		System.out.println("main end");
	}
}