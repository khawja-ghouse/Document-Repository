
class A < T >
{
	T obj;
}

class M52
{
	static void test(A<? super Number> arg)
	{
	
	}
	public static void main(String[] args) 
	{
			test(new A<String>());
			test(new A<Number>());
			test(new A<Integer>());
			test(new A<Object>());
			System.out.println("done:");
	}
}