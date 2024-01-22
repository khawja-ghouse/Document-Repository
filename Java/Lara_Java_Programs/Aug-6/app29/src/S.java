abstract class A
{
	abstract void test();
}
class S extends A 
{
		void test(int i)
	{
		System.out.println("froom subclass.test(int )");
	}
	public static void main(String[] args) 
	{
		S obj = new S();
		obj.test();
		System.out.println("done");
	}
}