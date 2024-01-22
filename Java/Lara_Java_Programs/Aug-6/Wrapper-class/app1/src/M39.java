class M39
{
	public static void test(Integer b1 ) 
	{
		System.out.println("Integer");
	}

	public static void test(byte ... b1) //last preference goes to vararg
	{
		System.out.println("byte ...");
	}
	public static void main(String[] args)
	{
		byte b1 = 10;
		test(b1);
	}
}