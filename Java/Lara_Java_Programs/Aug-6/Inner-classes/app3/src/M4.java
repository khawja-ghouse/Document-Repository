class M4 
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
			}
		};//desinging a ANC  by choosing the subclass for the perticular superclass
		a1.test1();
		a1.test2();
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
