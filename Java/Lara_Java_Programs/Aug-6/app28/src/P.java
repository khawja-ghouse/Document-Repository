interface A
{
	void test1();
}

 interface B 
{
	void test2();
}
class P implements A,B
{
	public void test1()
	{
		System.out.println("from test1()!");
	}
	public void test2()
	{
		System.out.println("from test2()!");
	}
	public static void main(String[] args) 
	{
		
		P obj = new P();
		obj.test1();
		obj.test2();
		System.out.println("DON!");
	}
}