class X

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		int i;
		for (i = 1,System.out.println("init");//successful bec here we are using initialization statement 
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
