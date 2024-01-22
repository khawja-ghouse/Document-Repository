class M38
{
	public static void test(Integer b1 ) 
	{
		System.out.println("Integer");
	}
	public static void test(Object b1 ) 
	{
		System.out.println("object");
	}
	public static void test(byte ... b1) 
	{
		System.out.println("byte ...");
	}
	public static void main(String[] args)
	{
		byte b1 = 10;
		test(b1);
	}
}