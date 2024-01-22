class A
{
	 void test(int i)
	{
		System.out.println("A.test(int)!");
	}
}
class B extends A
	{
		void test(int i)
		{
			System.out.println("B.test(int)");
		}
	}
class Z
{	
    public static void main(String[] args)
	{
		B b1 = new B();
		b1.test(10);
		System.out.println("DONE");
		A a1 = new A();
		a1.test(23);
	}
}

//A class test method is not available in the B class bec a class test method got overridded 