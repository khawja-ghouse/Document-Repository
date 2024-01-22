interface A
{
	void test();
}
class  M1
{
	public static void main(String[] args) 
	{
		A a1 = new A()
		{
			public void test()

			{
				System.out.println("from test");
			}
		};
		a1.test();
		System.out.println("Hello World!");

		A a2 = () -> System.out.println("from test");
		a2.test();//lamda expr is only fr single method interface
	}//if multiple interfaces methods then v cant use single method interface
}
//() [method] -> [method defination]  System.out.println("from test");[ body of the method ]
