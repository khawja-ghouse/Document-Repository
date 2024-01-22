class A 
{
	static int i = test();
	static int j = test();
	public static int test()
	{
		System.out.println("from test:");
		return i + j + 10;
	}
	public static void main(String[] args) 
	{
		System.out.println("from main"+ i + "," + j);
	}
}
