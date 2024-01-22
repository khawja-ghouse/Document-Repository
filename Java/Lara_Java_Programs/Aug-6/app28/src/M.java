interface A
{
	void test1();
	void test2();
}

abstract class B implements A 
{
	public void test1()// implemented with public 
	{
		System.out.println("from B.test1()!");
	}
}
class M extends B
{
	public void test2()// implemented with public 
	{
		System.out.println("from M.test2()!");
	}
	public static void main(String[] args) 
	{
		
		M obj = new M();
		obj.test1();
		obj.test2();
		System.out.println("DON!");
	}
}
//