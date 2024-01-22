abstract class A
{
	abstract void test();
}
class T extends A 
{
	int  test()//method attempting to override with different return type but signature is same 
	{
		System.out.println("froom subclass.test(int )");
		return 10;
	}
	public static void main(String[] args) 
	{
		T obj = new T();
		obj.test();
		System.out.println("done");
	}
}