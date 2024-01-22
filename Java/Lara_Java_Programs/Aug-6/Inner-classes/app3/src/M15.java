class M15 
{
	public static void main(String[] args) 
	{
		D d1 = new D()//we ill not use the implement keyword
		{
			public void test1()
			{
				System.out.println("from AID.test1()!");
			}
			public void test2()
			{
				System.out.println("from AID.test2()!");
			}
		};
		d1.test1();
		d1.test2();
		System.out.println("Hello!");
	}
}
/*
		{
			public void test1()
			{
				System.out.println("from AID.test1()!");
			}
			public void test2()
			{
				System.out.println("from AID.test2()!");
			}
		};
the above lines are body of AIN which implements test1 and test2

*/