class Y
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int x;
		test(x);
		System.out.println("main end ->");
	}
	public static void  test(int i)
	{
		System.out.println("from test:" + i);
	}
}
