class O
{
	static int i =test();
	static int j = 10;
	public static int  test()
	{
		System.out.println("test:");
		return j;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("main:"+i + ","+j);
	}
}
