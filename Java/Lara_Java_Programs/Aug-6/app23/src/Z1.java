class A
{
	A()
	{
		System.out.println("A()");
	}
}
class B extends A 
{
	B()
	{
		System.out.println("B()");
	}
	B(int i)
	{
		System.out.println("B(int )");
		this();//cmp error bec the A() constructor is executing twice for the same object creation;
		//when ever v are calling B(int ) the A() constructor is being called two time for B(int)
		// hence the compiler is geting error when v are give the this() and super() stms as 2 or other stmt 
	}
}
class Z1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello main!");
	}
}
