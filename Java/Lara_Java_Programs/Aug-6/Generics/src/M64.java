class A 
{
	static <T> void test(T obj1,T obj2)
	{
	}
}
class  M64
{
	public static void main(String[] args) 
	{
		A.test(100,200);
		A.test("def","abc");
		A.test("def",500);
		A.test(4.5,"abc");

		System.out.println("Hello World!");
	}
}