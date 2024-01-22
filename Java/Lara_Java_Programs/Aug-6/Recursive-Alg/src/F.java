class F 
{
	static void test(int i)
	{
		if( i == args[1] + 1)
		{
			return;
		}
		System.out.println(i);
		i++;
		test(i);
	}
	public static void main(String[] args) 
	{
		if (args.length < 2)
		{
			System.out.println(" pls enter the two ranges ");
			return;
		}
		
		test(args[0]);
	}
}
