class Z
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 10;
		test(i);
		System.out.println("main end ->" +i);//10
	}
	public static void  test(int i)
	{
		System.out.println("from test:" + i);
		i = 20;
	}
}
