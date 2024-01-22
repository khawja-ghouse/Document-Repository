class U
{
	static int i = test();
	public static int test()
	{
		System.out.println("from test:" + i );
		main(null);//calling a main from another method by passing null as argument
		System.out.println("from test:" + i );
		return 10;
	}
	public static void main(String[] args) 
	{
		System.out.println("main1:"+i);
		i = 5;
		System.out.println("main1:"+i);
	}

}
