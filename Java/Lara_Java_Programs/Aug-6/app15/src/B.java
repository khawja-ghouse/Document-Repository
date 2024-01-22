class B 
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = test();
		System.out.println("main end" + i);
	}
	public static int test()
	{
		System.out.println("test begin");
		int x = 200;
		return x;//returning a local variable x;
	}
}
