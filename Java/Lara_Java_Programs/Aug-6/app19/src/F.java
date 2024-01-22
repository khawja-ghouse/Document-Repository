class F
{
	static 
	{
		System.out.println("sib1:");
		test();
	}
	static 
	{
		System.out.println("sib2:"+i);//direct read without changing the state to any kind of read and write
		test();
	}
	static int i;
	public static void test()
	{
		System.out.println("test:"+i);//indirect
	}
	public static void main(String[] args) 
	{
		System.out.println("main:"+i);
	}
}
