class A
{
	static
	{
		System.out.println("A-SIB");
	}
	A()
	{
		System.out.println("A()");
	}
}
class  B extends A
{
	static
	{
		System.out.println("B-SIB");
	}
	B()
	{
		System.out.println("B()");
	}
}
class Y 
{
	static
	{
		System.out.println("Y-SIB");
	}
	public static void main(String[] args) 
	{
		System.out.println("Y-main begin");
		A a1 = new A();
		System.out.println("............");
		B b1 = new B();
		System.out.println("............");
		System.out.println("Y-main end");
	}
}
