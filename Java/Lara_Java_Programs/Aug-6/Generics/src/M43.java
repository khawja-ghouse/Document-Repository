class A <T> 
{
	T obj;
}
class M43
{
	static void test(A<?> arg)
	{
		arg.obj = "abc";
	}
	public static void main(String[] args) 
	{
		test(new A<String>());
		 System.out.println("Hello World!");
	}
}
