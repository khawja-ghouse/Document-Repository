class W
{
	static int i = test();
	static int j = test();
	public static int test()
	{
		System.out.println("from test1:" + i + "," + j );
		i += 5;
		j += i + 5;
		main(null);
		i += 5;
		j += i + 5;
		System.out.println("from test2:" + i + ","+ j );
		return i + j + 5;
	}
	public static void main(String[] args) 
	{
		System.out.println("main1:"+i+ ","+ j);
		i += j + 10;
		j += i + 10;
		System.out.println("main1:"+i+ ","+ j);
		
	}

}
