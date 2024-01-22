class M
{

	public static void main(String[] args) 
	{
	    class A//local inner class
	    {
			void test()
			{
				System.out.println("from A");
				System.out.println("from A");
				System.out.println("from A");
				System.out.println("from A");
			}
	    }	
		A a1 = new A();
		a1.test();
		a1.test();
		a1.test();
		System.out.println("Hello!");
	}
}
//local innerclass can be designed anywer in the defination block
//here class A cannot be used outside the main method 