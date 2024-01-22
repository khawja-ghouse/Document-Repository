class T
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test(10,20.0);
		System.out.println("main end ->");
	}
	public static void  test(int i,int j)
	{
		System.out.println("from test:" + i + ","+ j );
	}
}
