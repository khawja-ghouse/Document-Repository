interface A
{
	void test1();
}
interface B 
{
	void test2();
}
interface C extends A,B
{
	void test3();
}
class Q implements C
{
	public void test1()
	{
		System.out.println("from test1()!");
	}
	public void test2()
	{
		System.out.println("from test2()!");
	}	
	public void test3()
	{
		System.out.println("from test3()!");
	}
	public static void main(String[] args) 
	{
		
		Q obj = new Q();
		obj.test1();
		obj.test2();
		obj.test3();
		System.out.println("DON!");
	}
}