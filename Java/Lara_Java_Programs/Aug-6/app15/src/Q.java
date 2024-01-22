class Q
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test(10);
		System.out.println("main end ->");
	}
	public static void  test(int i,int j)
	{
		System.out.println("from test" + i);
		i = 20;
	}
}
