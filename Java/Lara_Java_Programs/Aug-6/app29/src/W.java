 class A
{
	 void test()
	{
		System.out.println("A.test()");
	}
}
class W extends A 
{
	static void  test()//non static method cannot be overrided with static and  static cannot be overrided with non static
	{
		System.out.println("subclass.test()");
	}
	public static void main(String[] args) 
	{
		W obj = new W();
		obj.test();
		System.out.println("done");
	}
}