class Z5
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 10;
		int  j = test(++i);//10 -----> 11
		System.out.println("main end ->" +i+" , " +j );//10
	}
	public static int  test(int i) //11
	{
		System.out.println("from test:" + i);
		return ++i;//12
	}
}
