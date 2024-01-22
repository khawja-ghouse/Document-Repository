class P
{
	int i;
	public static void test()
	{
		P ref1 = new P();
		ref1.i = 20;
		System.out.println("test:"+ref1.i);
	}
	public static void main(String[] args) 
	{
		P ref1 = new P();
		ref1.i = 10;
		System.out.println("main:"+ref1.i);
		test();
		System.out.println("main:"+ref1.i);
	}
}
