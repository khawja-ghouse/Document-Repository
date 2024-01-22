class F
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test();
		System.out.println("..............");
		test();//defined method can be called from any where and can be called any no of time;
		System.out.println("main end");
	}
	public static void test()//method defination
	{
		
		System.out.println("from begin");
		int i = 20;
		System.out.println("from test"+i);
		i = 30;
		System.out.println("from test:" + i);

	}
}
