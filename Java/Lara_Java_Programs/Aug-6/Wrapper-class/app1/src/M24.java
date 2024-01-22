class M24
{
	static void test1(Integer obj)
	{
		System.out.println("test1(Integer)");
	}
	static void test1(Number obj)
	{
		System.out.println("test1(Number)");
	}
	/*static void test1(double d1)
	{
		System.out.println("test1(double)");
	}*/
	public static void main(String[] args) 
	{
		byte b1  = 10;
		test1(b1);
		System.out.println("--------------");
	}
}
//auto boxing
//first preference goes to widening --> then boxing 
//when there is not byte wraper then it goes to the Number wraper class auto up casting 