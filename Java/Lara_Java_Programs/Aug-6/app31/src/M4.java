class M4
{
	static B test1()
	{
		return new B();
	}
	static C test2()
	{
		C c1 = null;
		return c1;
	}
	public static void main(String[] args) 
	{
		B obj1 = test1();
		C obj2 = test2();
		System.out.println("done");
	
	}
}
