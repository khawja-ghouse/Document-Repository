interface A
{
	void test1();
	void test2();
}

class L implements A 
{
	public void test1()// implemented with public 
	{
		System.out.println("from L.A!");
	}
	public void test2()// implemented with public 
	{
		System.out.println("from L.A!");
	}
	public static void main(String[] args) 
	{
		A a2 = null;
		L obj = new L();
		obj.test1();
		obj.test2();
		System.out.println("DON!");
	}
}