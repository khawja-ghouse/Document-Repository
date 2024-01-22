class V
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test(10);
		System.out.println("main end ->");
	}
	public static void  test(int i)
	{
		int i =20.0;//cmp time error bec int i is already used in arguments defination
		System.out.println("from test:" + i);
	}
}
