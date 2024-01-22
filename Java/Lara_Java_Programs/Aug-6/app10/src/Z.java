class Z

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		for (int i = 1;i <= 10 ;i++ )
		{
			System.out.println("loop begin"+ i);
			if (i <= 5)
			{
				System.out.println("if block:"+i);
				continue;	
			}
			System.out.println("loop end"+ i);
		}
		System.out.println("main end");
	}
}
