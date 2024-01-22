class C
{
	public static void test(double d1 )
	{
		System.out.println("test"+d1);
	}
	public static void main(String[] args) 
	{
		byte b1 = 100;
		short s1 = 100;
		int i = 100;
		float f1 = 100;
		double d1 = 100;
		test(b1);
		test(s1);
		test(i);// test((double)i)
		test(f1);
		test(d1);
		System.out.println("Done");
	}
}
