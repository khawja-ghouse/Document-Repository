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
class X
{	
    public static void main(String[] args)
	{
		A a1 = new A();
		a1.test();
		A a2 = new B();
		a2.test();
		B b1 = new B();
		b1.test();
		System.out.println("DONE");
	}
}

//overloading = same names of method but difference in no of arguments or datatype of the arguments
//Inherited method can be overloaded with the incorporated method
//