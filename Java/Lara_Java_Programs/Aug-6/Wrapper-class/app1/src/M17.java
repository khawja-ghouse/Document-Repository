class M17
{
	static void test(Integer i)
	{
		System.out.println("test(Integer)");
	}
	public static void main(String[] args) 
	{
		test(10);//test(new Integer(10))
		System.out.println("--------------");

		Integer obj = new Integer(90);

		test(obj);//test(obj.inValue());
	}
}