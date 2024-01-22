class A
{
	void test(String arg)
	{
	}
}
class M5
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.test("abc");
		//for every object test method arguments is fixed that is Srting
		a2.test("hello");
		a3.test("xyz");
		System.out.println("done");
	}
}