abstract class A
{
	abstract void test();
}
class U extends A 
{
	public void  test()//while overriding a method access level should be same or wider or default in both 
	{
		System.out.println("subclass.test()");
	}
	public static void main(String[] args) 
	{
		T obj = new T();
		obj.test();
		System.out.println("done");
	}
}