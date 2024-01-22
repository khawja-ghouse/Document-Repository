class Z6
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 10;
		int  j = test1(++i) + i + test2(i++) + i + test3(i--) + i + test4(--i) + i;
		System.out.println("main end ->" +i+" , " +j );
	}
	public static int  test1(int i) 
	{
		System.out.println("from test1:" + i);
		return i++;
	}	
	public static int  test2(int i) 
	{
		System.out.println("from test2:" + i);
		return --i;
	}	
	public static int  test3(int i) 
	{
		System.out.println("from test3:" + i);
		return ++i;
	}	
	public static int  test4(int i)
	{
		System.out.println("from test4:" + i);
		return i--;
	}
}
