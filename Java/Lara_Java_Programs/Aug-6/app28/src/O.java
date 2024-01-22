interface A
{
	void test1();
}

class B 
{
	public void test2()
	{
		System.out.println("from test2()!");
	}
}
 class O extends B implements A
{
	public void test1()
	{ 
		System.out.println("from test1()!");
	}
	public static void main(String[] args) 
	{
		
		O obj = new O();
		obj.test1();
		obj.test2();
		System.out.println("DON!");
	}
}