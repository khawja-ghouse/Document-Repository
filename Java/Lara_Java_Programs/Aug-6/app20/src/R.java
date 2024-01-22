class R
{
	int i;
	public static void test(R arg)
	{
		System.out.println("test:"+arg.i);
		arg.i=20; 

	}
	public static void main(String[] args) 
	{
		R ref1 = new R();
		ref1.i = 10;
		System.out.println("main1:"+ref1.i);
		test(ref1);
		System.out.println("main2:"+ref1.i);
	}
}
