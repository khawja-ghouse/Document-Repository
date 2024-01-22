class Z8
{
	public static void main(String[] args) 
	{
				System.out.println(test1() || test2() || test3());


	}
	public static boolean test1()
	{
				System.out.println("test1");
				return false;
	}
	 public static boolean test2()
	{
				System.out.println("test2");
				return true;
	}
	 public static boolean test3()
	{
				System.out.println("test3");
				return true;
	}
}
