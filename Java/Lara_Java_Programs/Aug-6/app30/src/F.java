class F
{
	static int test()
	{
		return 100;
	}
	public static void main(String[] args) 
	{
		int i = test();
		long lon = test();
		float f1= test();
		double d1 = (double)test();
		System.out.println("Done");
	}
}
