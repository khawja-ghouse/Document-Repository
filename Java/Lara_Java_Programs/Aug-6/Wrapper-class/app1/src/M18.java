class M18
{
	static void test(double j)
	{
		System.out.println("test(double)");
	}
	public static void main(String[] args) 
	{
		test(10);//test((double) 10)
		System.out.println("--------------");
		int i = 200;
		test(i);//test((double) i);
	}
}
