class E
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test();//calling stsm
		System.out.println("main end");
	}
	public static void test()//method defination
	{
		System.out.println("from test");
		System.out.println("from test");
		System.out.println("from test");
		int i = 20;//i is local to the test method i can't be used outside the test method;
		System.out.println("from test");
		i = 30;
		System.out.println("from test:" + i);

	}
}
