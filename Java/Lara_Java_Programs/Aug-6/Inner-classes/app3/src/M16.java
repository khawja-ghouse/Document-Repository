class M16 
{
	public static void main(String[] args) 
	{
		D d1 = new D()//we ill not use the implement keyword
		{
			public void test2()
			{
				System.out.println("from AID.test2()!");
			}

		};
		d1.test2();
		System.out.println("Hello!");
	}
}