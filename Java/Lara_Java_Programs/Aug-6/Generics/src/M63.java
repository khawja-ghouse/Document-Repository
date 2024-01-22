class A 
{
	static <T> void test(T obj1,T obj2)
	{

	}
}
class  M63
{
	public static void main(String[] args) 
	{
		A.<Integer>test(100,200);
		A.<String>test("def","abc");
		System.out.println("Hello World!");
	}
}