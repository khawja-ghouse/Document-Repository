class M13 
{
	public static void main(String[] args) 
	{
		C c1 = new C()
		{
			void test1()
			{
				System.out.println("from AIC.test1()!");
			}
		};//AIN where ever v are devloping there itself object is creating if v are creating object then that class can not be abstract
		c1.test1();//As there is no name does not have a name to creat the object 
		c1.test2();
		System.out.println("Hello!");
	}
}
//CTE