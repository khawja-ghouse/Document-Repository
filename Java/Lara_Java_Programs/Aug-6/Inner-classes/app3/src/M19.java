class M19
{
	public static void main(String[] args) 
	{
		E e1 = new E();
		e1.method1(new A()
		{
			void test1()
			{
				System.out.println("from E.AIC.test1");
			}
			void test2()
			{
				System.out.println("from E.AIC.test2");
			}
		});

		System.out.println("Hello!");
	}
}