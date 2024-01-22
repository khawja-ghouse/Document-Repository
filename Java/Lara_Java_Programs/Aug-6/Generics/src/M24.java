class A < X >
{
	X obj;
}
class M24
{
	static void test(A < ? > a1)
	{

	}
	public static void main(String[] args) 
	{	
		test(new  A<Integer>());
		test(new  A<Object>());
		test(new  A<P>());
		test(new  A<String>());
		test(new  A<Thread>());
		System.out.println("Hello World!");
	}
}