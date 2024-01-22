class S
{
	int i;
	public static  S test()
	{
		S s1 = new S();
		s1.i = 10;
		System.out.println("test:"+s1.i);
		return s1;
	}
	public static void main(String[] args) 
	{
		S obj = test();
		System.out.println("main1:"+obj.i);
	}
}
