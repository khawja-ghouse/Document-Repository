class A
{
	void test()
	{
		System.out.println("froom A.test");
	}
}
class Q extends A 
{
	void test(int i )
	{
		System.out.println("from subclass.test(int )");
	}
	public static void main(String[] args) 
	{
		Q q1 = new Q();
		q1.test(12);//over loaded
		q1.test();
		System.out.println("done");
	}
}