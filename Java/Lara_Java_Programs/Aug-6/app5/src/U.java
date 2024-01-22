class U 
{
	public static void main(String[] args) 
	{
		int i =0;
		System.out.println((i++ == 0) || (i++ == 0)  && (i++ == 0));
				System.out.println(i);
				System.out.println(test1() || test2() && test3() && test1());


	}
	static boolean test1()
	{
				System.out.println("test1");
				return true;
	}
	static boolean test2()
	{
				System.out.println("test2");
				return true;
	}
	static boolean test3()
	{
				System.out.println("test3");
				return true;
	}
}
