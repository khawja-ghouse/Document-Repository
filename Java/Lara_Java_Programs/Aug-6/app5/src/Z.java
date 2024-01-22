class Z
{
	public static void main(String[] args) 
	{
				System.out.println(test1() || test2() );


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
}
