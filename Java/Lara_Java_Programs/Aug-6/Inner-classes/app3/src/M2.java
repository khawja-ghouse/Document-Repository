class M2 
{
	public static void main(String[] args) 
	{
		A a1 = new A()//A(super class reference ) = ( object to subclass class of A)auto upcasting 
		{
			void test1()//test1 geting overrideing 
			{
				System.out.println("AIC.test1()");
			}
		};//this is the body of annonimus class(class that does not have a name )
		a1.test1();
		a1.test2();
	}
}
