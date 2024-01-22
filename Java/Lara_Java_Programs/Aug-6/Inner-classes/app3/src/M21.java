class M21 
{
	public static void main(String[] args) 
	{
		G.method1(new D()
		{
			public void test2()
			{
				System.out.println("from test2F");
			}
			public void test1()
			{
				System.out.println("from test1F");
			}
		});
		System.out.println("Hello World!");
	}
}
