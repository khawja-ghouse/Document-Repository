abstract class A
{
	abstract void test();
}
class  B extends A
{
	void test()
	{
		System.out.println("from B.test()");
	}
}
class C extends A
{
	void test()
	{
		System.out.println("from C.test()");
	}

}
class M4
{
	public static void main(String[] args) 
	{
		
		A a1 = new B();
		A a2 = new C();
		A[] elements = {a1,a2};
		for (A element:elements)
		{
			element.test();//same statement executing many times resulting different value 
		}
	}
}