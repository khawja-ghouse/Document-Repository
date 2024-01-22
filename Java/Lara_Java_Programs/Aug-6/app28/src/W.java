class V
{
	void test()
	{
		System.out.println("V.test()!");
	}
}
class W extends V
{
		void test(int i)
		{
			System.out.println("W.test(int)");
		}
	
      public static void main(String[] args)
	{
		W w1 = new W();
		w1.test();
		w1.test(20);
	}
}

//overloading = same names of method but difference in no of arguments or datatype of the arguments
//Inherited method can be overloaded with the incorporated method
//