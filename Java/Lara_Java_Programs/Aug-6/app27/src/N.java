abstract class A
{
	void test1()
	{
		System.out.println("from A.test1()");
	}
	abstract void test2();
	abstract void test3();
}
class B extends A
{
    void test2()
	{
		System.out.println("from B.test2()");
	}
}
class N extends B
{
	void test3()
	{
		System.out.println("from M.test3()");
	}
	public static void main(String[] args)
	{
		N obj = new N();
		obj.test1();
		System.out.println("............");
		obj.test2();
		System.out.println("............");
		obj.test3();
	}
}
/*

*/