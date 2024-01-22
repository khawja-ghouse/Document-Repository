class A
{
	void test(Integer arg)
	{
	}
}
class M6
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.test(20);
		a2.test(40);
		a3.test(60);
		System.out.println("done");
	}
}