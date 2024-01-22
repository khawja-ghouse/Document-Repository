abstract class A
{
	void test1()
	{

	}
	abstract void test2();
}
class G
{
	public static void main(String[] args)
	{
		A a1 = new A();
		System.out.println("DON");
	}
}
//G.java:13: error: A is abstract; cannot be instantiated
//                A a1 = new A();
                       ^
//1 error
//we can't create object for the abstract class