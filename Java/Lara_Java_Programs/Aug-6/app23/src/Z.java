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
class Z 
{
	static
	{
		System.out.println("Z-SIB");
	}
	public static void main(String[] args) 
	{
		System.out.println("Z-main begin");
		B b1 = new B();
		System.out.println("............");
		A a1 =new A();
		System.out.println("............");
		System.out.println("Z-main end");
	}
}
