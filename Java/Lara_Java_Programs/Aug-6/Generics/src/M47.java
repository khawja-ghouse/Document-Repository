class A <T> 
{
	T obj;
}
class M47
{
	static void test(A< ? extends Number>arg)
	{
	}
	public static void main(String[] args) 
	{
		test(new A<Number>());
		test(new A<Integer>());
		test(new A<Byte>());
		test(new A<String>());
		test(new A<Object>());
		System.out.println("Hello World!");
	}
}

