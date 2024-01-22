abstract class A
{
	protected int i = 20;
	abstract void test1();
	abstract void test2();
	abstract void test3();

}
abstract class B extends A
{
    void test1()
	{
		System.out.println("from B.test1()"+i);
	}
}
abstract class C extends B
{
	void test2()
	{
		System.out.println("from C.test2()"+i);
	}
}
class D extends C
{
	void test3()
	{
		System.out.println("from B.test1()"+i);
	}

}
class O
{
	public static void main(String[] args)
	{
	//	O obj = new O();
	//	obj.test1();
	//	System.out.println("............");
	//	obj.test2();
	//	System.out.println("............");
	//	obj.test3();
	D d1 = new D();
	d1.test1();
	d1.test3();
	d1.test2();
	System.out.println("..done..");
	}
}
/*

*/