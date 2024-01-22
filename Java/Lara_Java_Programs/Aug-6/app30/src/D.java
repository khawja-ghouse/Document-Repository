class D
{
	public static void test(int d1 )
	{
		System.out.println("test:"+d1);
	}
	public static void main(String[] args) 
	{
		byte b1 = 100;
		short s1 = 100;
		int i = 100;
		test((int)b1);//explicitly conversion is not required but still can be provided
		test((int)s1);
		test(i);// test(i)
		System.out.println("Done");
	}
}
