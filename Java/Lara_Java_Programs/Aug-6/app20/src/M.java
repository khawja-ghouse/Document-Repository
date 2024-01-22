class M
{
	int i;
	public static void test()
	{
		M m1 = new M();
		System.out.println("test:"+m1.i);
	}
	public static void main(String[] args) 
	{
		M m1 = new M();
		System.out.println("main:"+m1.i);
		test();//static method can call directly
	}
}
