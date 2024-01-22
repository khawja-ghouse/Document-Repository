class O
{
	int i;
	public static void test()
	{
		O ref1 = new O();
		System.out.println("test:"+ref1.i);
	}
	public static void main(String[] args) 
	{
		O ref1 = new O();
		ref1.i = 10;
		System.out.println("main:"+ref1.i);//10
		test();//0
	}
}
