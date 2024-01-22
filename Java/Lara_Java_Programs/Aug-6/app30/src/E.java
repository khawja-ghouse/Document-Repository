class E
{
	static byte test()
	{
		return 100;
	}
	public static void main(String[] args) 
	{
		byte b1 = test();
		short s1 = test();
		int i = test();
		long lon = test();
		float f1= test();
		double d1 = test();
		System.out.println("Done");
	}
}
