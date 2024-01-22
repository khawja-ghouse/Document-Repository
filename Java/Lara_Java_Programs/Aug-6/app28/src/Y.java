class A
{
	 void test()
	{
		System.out.println("A.test()!");
	}
}
class B extends A
	{
		void test()
		{
			System.out.println("B.test()");
		}
	}
class Y
{	
    public static void main(String[] args)
	{
		B b1 = new B();
		b1.test();
		System.out.println("DONE");
		A a1 = new A();
		a1.test();
	}
}

//A class test method is not available in the B class bec a class test method got overridded 