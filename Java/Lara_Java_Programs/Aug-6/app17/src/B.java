class B
{
	static int i = test();
	static int j = test();
	public static int test()
	{
		System.out.println("from test:" + i + "," + j);
		i += j+5;
		j += i+5;
		return i + j + 10;
	}
	public static void main(String[] args) 
	{
		System.out.println("from main"+ i + "," + j);
	}
}
