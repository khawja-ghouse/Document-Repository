class K
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		String s1 = test();
		System.out.println("main end ->" + s1);
	}
	public static String  test()
	{
		System.out.println("from test");
		return "sabiha";
	}
}
