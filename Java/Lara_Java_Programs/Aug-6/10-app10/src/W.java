class W
{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		
		for (int i = 1,System.out.println("init");//cmp error bec the int i = 1, compiler will be expecting the another variable declaration like int i = i,k=3..
			test(i);
			i++,System.out.println("change"+ i))
		{

		System.out.println("loop body:"+ i);
		}
		System.out.println("main end :" + i);
	}
	public static boolean test (int i )
	{
		boolean b1 =( i <= 5);
		System.out.println("boolean test for" + i + ":"+ b1);
		return b1;
	}
}
