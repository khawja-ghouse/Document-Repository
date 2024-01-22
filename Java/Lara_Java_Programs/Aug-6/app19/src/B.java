class B
{
	static int i = 10;
	static 
	{
		System.out.println("sib:"+i);//direct
		test();
	}
	public static void test()
	{
		System.out.println("test:"+i);//indirect
	}
	public static void main(String[] args) 
	{
		System.out.println("main:"+i);
	}
}
