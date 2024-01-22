class M20 
{
	public static void main(String[] args) 
	{
		F.method(new C()
		{
			void test2()
			{
				System.out.println("from test2F");
			}
		});
		System.out.println("Hello World!");
	}
}
