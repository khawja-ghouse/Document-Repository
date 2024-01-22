class A <T> 
{
	void test(T arg)
	{
	

	}
}
class M44
{
	public static void main(String[] args) 
	{
		A<?> a1 = new A<String>();
		a1.test("abc");
		System.out.println("Hello World!");
	}
}

