class L
{
	static int x = test();
	static int y;
	static int z = y;
	public static int test()
	{
		return y;
	}
	public static void main(String[] args) 
	{
		System.out.println(x +"," +y+","+z);
	}
}
