abstract class A
{
	void test1()
	{
		System.out.println("from A.test()");
	}
	abstract void test2();
}
class L extends A
{
    void test2()
	{
		System.out.println("from L.test()");
	}
		
	public static void main(String[] args)
	{
		L obj = new L();
		obj.test1();
		System.out.println("............");
		obj.test2();
	}
}
/*

*/