class M6 
{
	public static void main(String[] args) 
	{
		A a1 = new A()
		{
			void test1()//test1 geting overrideing 
			{
				System.out.println("AIC.test1()");
			}
			void test2()
			{
				System.out.println("AIC.test2()");
				test3();
			}
			void test3()
			{
				System.out.println("AIC.test3()");
			}
		};//desinging a ANC  by choosing the subclass for the perticular superclass
		//ANC new members cannot be used from outside
		//ANC new members can be called ascced within the class
		
		a1.test1();
		a1.test2();
		//a1.test3();//CTE as a1 is reference of A compiler checks test3() presence in the A class first
	}
}
/*
		{
			void test2()
			{
				System.out.println("AIC.test2()");
			}
		};complet body is  development of new class 

*/
