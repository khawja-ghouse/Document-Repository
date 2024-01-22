 class A
{
	protected void test()
	{
		System.out.println("A.test()");
	}
}
class V extends A 
{
	void  test()
	{
		System.out.println("subclass.test()");
	}
	public static void main(String[] args) 
	{
		V obj = new V();
		obj.test();
		System.out.println("done");
	}
}